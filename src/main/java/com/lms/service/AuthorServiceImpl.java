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

	@Override
	public void addAuthor(Author author) {
		authorRepo.save(author);
	}

	@Override
	public Author getAuthor(Integer idAuthors) {
		return authorRepo.getOne(idAuthors);
	}

	@Override
	public Author createOrUpdateAuthor(Author author) {
		if (author.getIdAuthors() == null) {
			return authorRepo.save(author);
		} else {
			Optional<Author> currAuthor = authorRepo.findById(author.getIdAuthors());
			if (currAuthor.isPresent()) {
				Author newAuthor = currAuthor.get();
				newAuthor.setAuthorsName(author.getAuthorName());
				newAuthor.setBooks(author.getBooks());
				return authorRepo.save(newAuthor);
			} else {
				return authorRepo.save(author);
			}
		}
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}

	@Override
	public Integer findAuthor(String authorName) {
		if (authorName != null) {
			List<Author> authors = getAllAuthors();
			for (Author author : authors) {
				if (author.getAuthorName().equals(authorName)) {
					return author.getIdAuthors();
				}
			}
		}
		return null;
	}

}
