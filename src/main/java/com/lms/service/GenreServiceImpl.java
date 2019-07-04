package com.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.models.Genre;
import com.lms.repository.GenreRepo;

@Service
public class GenreServiceImpl implements GenreService {
	
	@Autowired
	private GenreRepo genreRepo;

	@Override
	public void addGenre(Genre genre) {
		// TODO Auto-generated method stub
		genreRepo.save(genre);
	}

	@Override
	public Genre getGenre(Integer idGenre) {
		// TODO Auto-generated method stub
		return genreRepo.getOne(idGenre);
	}

	@Override
	public Genre updateGenre(Integer idGenre, Genre genre) {
		// TODO Auto-generated method stub
		return genreRepo.save(genre);
	}

	@Override
	public List<Genre> getAllGenres() {
		// TODO Auto-generated method stub
		return genreRepo.findAll();
	}

}
