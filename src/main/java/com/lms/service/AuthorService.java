package com.lms.service;

import java.util.List;

import com.lms.models.Author;

public interface AuthorService {
	public void addAuthor(Author author);

	public Author getAuthor(Integer idAuthors);
	
	public Integer findAuthor(String authorName);

	public Author createOrUpdateAuthor(Author author);

	public List<Author> getAllAuthors();
}
