package com.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.models.Author;
import com.lms.repository.AuthorRepo;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepo authorRepo;

	public Author addAuthor(Author author) {
		return authorRepo.save(author);
	}

	@Override
	public Author getAuthor(Integer idAuthors) {
		return authorRepo.getOne(idAuthors);
	}

	@Override
	public Author createOrUpdateAuthor(Author author) {
		if (author.getIdAuthors() == null) {
			return addAuthor(author);
		} else {
			Optional<Author> currAuthor = authorRepo.findById(author.getIdAuthors());
			if (currAuthor.isPresent()) {
				Author newAuthor = currAuthor.get();
				newAuthor.setAuthorName(author.getAuthorName());
				newAuthor.setBooks(author.getBooks());
				return addAuthor(newAuthor);
			} else {
				return addAuthor(author);
			}
		}
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}
}
