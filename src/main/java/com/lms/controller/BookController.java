package com.lms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lms.models.Author;
import com.lms.models.Book;
import com.lms.models.Genre;
import com.lms.service.AuthorService;
import com.lms.service.BookService;
import com.lms.service.GenreService;

@Controller
public class BookController {
	@Autowired
	private BookService bookRepo;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private GenreService genreService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ModelAndView showAll() throws IOException {
		List<Book> listOfBooks = bookRepo.getAllBooks();
		return new ModelAndView("bookList", "listOfBooks", listOfBooks);
	}

	@RequestMapping(value = "/add_book", method = RequestMethod.GET)
	public ModelAndView newBook(ModelAndView model) {
		Book book = new Book();
		model.addObject("book", book);
		List<Author> authorList = authorService.getAllAuthors();
		model.addObject("authorList", authorList);
		List<Genre> genreList = genreService.getAllGenres();
		model.addObject("genreList", genreList);
		model.setViewName("addBook");
		return model;
	}

	@RequestMapping(value = "/edit_book", method = RequestMethod.GET)
	public ModelAndView updateBook(HttpServletRequest request, ModelAndView model) {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookRepo.getBook(bookId);
		model.addObject("book", book);
		List<Author> authorList = authorService.getAllAuthors();
		model.addObject("authorList", authorList);
		List<Genre> genreList = genreService.getAllGenres();
		model.addObject("genreList", genreList);
		model.setViewName("addBook");
		return model;
	}

	@RequestMapping(value = "/save_book", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute Book book, @RequestParam("file") MultipartFile file)
			throws IOException {
		if (!file.isEmpty()) {
			book.setBookFileName(file.getOriginalFilename());
			book.setBookFile(file.getBytes());
			book.setBookFileType(file.getContentType());
		} else {
			book.setBookFileName(bookRepo.getBook(book.getIdBooks()).getBookFileName());
			book.setBookFile(bookRepo.getBook(book.getIdBooks()).getBookFile());
			book.setBookFileType(bookRepo.getBook(book.getIdBooks()).getBookFileType());
		}
		bookRepo.createOrUpdateBook(book);
		return new ModelAndView("redirect:/books");
	}

	@RequestMapping(value = "/delete_book", method = RequestMethod.GET)
	public ModelAndView deleteBook(HttpServletRequest request) {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		bookRepo.deleteBook(bookId);
		return new ModelAndView("redirect:/books");
	}

	@RequestMapping(value = "/show_info", method = RequestMethod.GET)
	public ModelAndView showBookInfo(HttpServletRequest request) {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		return new ModelAndView("showInfo", "book", bookRepo.getBook(bookId));
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<ByteArrayResource> downloadBookFile(HttpServletRequest request) {
		Integer bookId = Integer.parseInt(request.getParameter("id"));
		Book book = bookRepo.getBook(bookId);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(book.getBookFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + book.getBookFileName() + "\"")
				.body(new ByteArrayResource(book.getBookFile()));
	}

	@RequestMapping(value = "/find_book", method = RequestMethod.GET)
	public ModelAndView search(ModelAndView model, @RequestParam(value = "search", required=false) String search,
			@RequestParam(value = "seacrhBy", required=false) String searchBy) {
		List<String> searchByList = new ArrayList<String>();
		searchByList.add("Book Title");
		searchByList.add("Book Author");
		searchByList.add("Book Year");
		searchByList.add("Book Description");
		model.addObject("listOfResults", searchByList);
		if (search != null) {
			List<Book> listOfBooks = bookRepo.getAllBooks();
			List<Book> listOfResults = new ArrayList<Book>();
			if (searchBy.equals("Book Title")) {
				for (Book book : listOfBooks) {
					if (book.getBookTitle().contains(search)) {
						listOfResults.add(book);
					}
				}
			}
			if (searchBy.equals("Book Author")) {
				for (Book book : listOfBooks) {
					if (book.getBooksAuthor().getAuthorName().contains(search)) {
						listOfResults.add(book);
					}
				}
			}
			if (searchBy.equals("Book Year")) {
				for (Book book : listOfBooks) {
					if (book.getBookYear() == Integer.parseInt(search)) {
						listOfResults.add(book);
					}
				}
			}
			if (searchBy.equals("Book Description")) {
				for (Book book : listOfBooks) {
					if (book.getBookDescription().contains(search)) {
						listOfResults.add(book);
					}
				}
			}
			model.addObject("listOfBooks", listOfResults);
		}
		model.setViewName("index");
		return model;
	}

//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public ModelAndView index() {
//		List<String> searchByList = new ArrayList<String>();
//		searchByList.add("Book Title");
//		searchByList.add("Book Author");
//		searchByList.add("Book Year");
//		searchByList.add("Book Description");
//		return 
//	}

}
