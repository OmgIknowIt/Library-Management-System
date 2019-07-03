package com.lms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lms.models.Books;
import com.lms.repository.BooksRepo;

@Controller
public class MainMenuController {
	@Autowired
	private BooksRepo bookRepo;
	
	@RequestMapping("/all")
	public @ResponseBody List<Books> showAll() {
		return bookRepo.findAll();
	}
}
