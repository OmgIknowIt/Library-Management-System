package com.lms.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lms.models.Book;
import com.lms.service.AuthorService;
import com.lms.service.BookService;
import com.lms.service.GenreService;

@Controller
public class MainMenuController {
	@Autowired
	private BookService bookRepo;
	@Autowired
	private GenreService genreRepo;
	@Autowired
	private AuthorService authorRepo;
	
	@RequestMapping(value="/all" , method = RequestMethod.GET)
	public ModelAndView showAll() throws IOException {
		List<Book> listOfBooks = bookRepo.getAllBooks();
		return new ModelAndView("bookList","listOfBooks", listOfBooks);
	}
}
