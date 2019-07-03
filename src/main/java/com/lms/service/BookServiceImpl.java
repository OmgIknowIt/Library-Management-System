package com.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.models.Books;
import com.lms.repository.BooksRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BooksRepo bookRepository;

	@Override
	public void addBook(Books book) {
		bookRepository.save(book);
	}

	@Override
	public Books getBook(Integer idBooks) {
		//return bookRepository.findOne(idBooks);
		return null;
	}

	@Override
	public Books updateBook(Integer idBooks, Books book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(Integer bookId) {
		//bookRepository.delete(bookId);
	}

	@Override
	public List<Books> getAllBooks() {
		List<Books> books = new ArrayList<>();
		bookRepository.findAll().forEach(books::add);
		return books;
	}

}
