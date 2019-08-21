package com.lms.service;

import java.util.List;

import com.lms.models.Author;

public interface AuthorService {

	public Author getAuthor(Integer idAuthors);

	public Author createOrUpdateAuthor(Author author);

	public List<Author> getAllAuthors();
}
