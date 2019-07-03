package com.lms.service;

import java.util.List;

import com.lms.models.Books;

public interface BookService {
	public void addBook(Books book);
	
	public Books getBook(Integer bookId);
	
	public Books updateBook(Integer idBooks,Books book);

	public void deleteBook(Integer idBooks);

	public List<Books> getAllBooks();
}
