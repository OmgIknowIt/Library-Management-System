package com.lms.service;

import java.util.List;

import com.lms.models.Author;

public interface AuthorService {
	public void addAuthor(Author author);

	public Author getAuthor(Integer idAuthors);

	public Author updateAuthor(Integer idAuthors, Author author);

	public List<Author> getAllAuthors();
}
