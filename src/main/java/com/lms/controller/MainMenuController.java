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

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ModelAndView showAll() throws IOException {
		List<Book> listOfBooks = bookRepo.getAllBooks();
		return new ModelAndView("bookList", "listOfBooks", listOfBooks);
	}

	@RequestMapping(value = "/add_book", method = RequestMethod.GET)
	public ModelAndView newBook() {
		Book book = new Book();
		return new ModelAndView("addBook", "book", book);
	}

	@RequestMapping(value = "/edit_book", method = RequestMethod.GET)
	public ModelAndView updateBook(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookRepo.getBook(bookId);
		return new ModelAndView("addBook", "book", book);
	}

	@RequestMapping(value = "/save_book", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute Book book) {
		if (book.getIdBook() == 0) {
			bookRepo.addBook(book);
		} else {
			bookRepo.updateBook(book.getIdBook(), book);
		}
		return new ModelAndView("redirect:/books");
	}

	@RequestMapping(value = "/delete_book", method = RequestMethod.GET)
	public ModelAndView deleteBook(HttpServletRequest request) {
		int bookId = Integer.parseInt(request.getParameter("id"));
		bookRepo.deleteBook(bookId);
		return new ModelAndView("redirect:/books");
	}
}
