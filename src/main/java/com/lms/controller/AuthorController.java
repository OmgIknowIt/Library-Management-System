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

import com.lms.models.Author;
import com.lms.service.AuthorService;

@Controller
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	@RequestMapping(value = "/authors", method = RequestMethod.GET)
	public ModelAndView showAll() throws IOException {
		List<Author> listOfAuthors = authorService.getAllAuthors();
		return new ModelAndView("authorList", "listOfAuthors", listOfAuthors);
	}

	@RequestMapping(value = "/add_author", method = RequestMethod.GET)
	public ModelAndView newAuthor() {
		return new ModelAndView("addAuthor", "author", new Author());
	}

	@RequestMapping(value = "/edit_author", method = RequestMethod.GET)
	public ModelAndView updateAuthor(HttpServletRequest request) {
		Integer authorId = Integer.parseInt(request.getParameter("id"));
		Author author = authorService.getAuthor(authorId);
		return new ModelAndView("addAuthor", "author", author);
	}

	@RequestMapping(value = "/save_author", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute Author author) {
		authorService.createOrUpdateAuthor(author);
		return new ModelAndView("redirect:/authors");
	}
}
