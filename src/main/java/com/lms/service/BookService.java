package com.lms.service;

import java.util.List;

import com.lms.models.Book;

public interface BookService {
	public Book getBook(Integer idBooks);

	public Book createOrUpdateBook(Book book);

	public void deleteBook(Integer idBooks);

	public List<Book> getAllBooks();
}
