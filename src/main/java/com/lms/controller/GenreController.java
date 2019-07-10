package com.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lms.models.Genre;
import com.lms.service.GenreService;

@Controller
public class GenreController {
	@Autowired
	private GenreService genreService;

	@RequestMapping(value = "/genres", method = RequestMethod.GET)
	public ModelAndView showAll() throws IOException {
		List<Genre> listOfGenres = genreService.getAllGenres();
		return new ModelAndView("genreList", "listOfGenres", listOfGenres);
	}

	@RequestMapping(value = "/add_genre", method = RequestMethod.GET)
	public ModelAndView newGenre() {
		return new ModelAndView("addGenre", "genre", new Genre());
	}

	@RequestMapping(value = "/edit_genre", method = RequestMethod.GET)
	public ModelAndView updateGenre(HttpServletRequest request) {
		Integer genreId = Integer.parseInt(request.getParameter("id"));
		Genre genre = genreService.getGenre(genreId);
		return new ModelAndView("addGenre", "genre", genre);
	}

	@RequestMapping(value = "/save_genre", method = RequestMethod.POST)
	public ModelAndView saveGenre(@ModelAttribute Genre genre) {
		genreService.createOrUpdateGenre(genre);
		return new ModelAndView("redirect:/genres");
	}
}
