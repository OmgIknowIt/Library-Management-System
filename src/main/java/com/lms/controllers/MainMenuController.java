package com.lms.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lms.models.Books;
import com.lms.repository.BooksRepo;
import com.lms.service.BookService;

@Controller
public class MainMenuController {
	@Autowired
	private BookService bookRepo;
	
	@RequestMapping(value="/all" , method = RequestMethod.GET)
	public @ResponseBody ModelAndView showAll(ModelAndView model) throws IOException {
		List<Books> listBooks = bookRepo.getAllBooks();
		model.addObject("listBooks", listBooks);
		model.setViewName("books");
		return model;
	}
}
