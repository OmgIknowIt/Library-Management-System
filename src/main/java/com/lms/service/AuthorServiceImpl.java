package com.lms.service;

import java.util.List;

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
		// TODO Auto-generated method stub
		authorRepo.save(author);
	}

	@Override
	public Author getAuthor(Integer idAuthors) {
		// TODO Auto-generated method stub
		return authorRepo.getOne(idAuthors);
	}

	@Override
	public Author updateAuthor(Integer idAuthors, Author author) {
		// TODO Auto-generated method stub
		return authorRepo.save(author);
	}

	@Override
	public List<Author> getAllAuthors() {
		// TODO Auto-generated method stub
		return authorRepo.findAll();
	}

}
