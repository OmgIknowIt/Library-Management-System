package com.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.models.Book;
import com.lms.repository.BooksRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BooksRepo bookRepository;

//	@Override
//	public void addBook(Book book) {
//		bookRepository.save(book);
//	}
//
//	@Override
//	public Book getBook(Integer idBooks) {
//		return bookRepository.findOne(idBooks);
//	}
//
//	@Override
//	public Book updateBook(Integer idBooks, Book book) {
//		return bookRepository.save(book);
//	}
//
//	@Override
//	public void deleteBook(Integer idBooks) {
//		bookRepository.delete(idBooks);
//	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

}
