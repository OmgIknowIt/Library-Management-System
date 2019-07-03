package com.lms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lms.models.Author;
import com.lms.models.Books;
import com.lms.repository.AuthorRepo;
import com.lms.repository.BooksRepo;

@Controller
public class MainMenuController {
	@Autowired
	private BooksRepo bookRepo;
	@Autowired
	private AuthorRepo aRepo;
	
	@RequestMapping("/all")
	public @ResponseBody List<Author> showAll() {
		return aRepo.findAll();
	}
}
