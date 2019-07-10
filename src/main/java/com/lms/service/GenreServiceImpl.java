package com.lms.service;

import java.util.List;
import java.util.Optional;

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
		genreRepo.save(genre);
	}

	@Override
	public Genre getGenre(Integer idGenre) {
		return genreRepo.getOne(idGenre);
	}

	@Override
	public Genre createOrUpdateGenre(Genre genre) {
		if (genre.getIdGenre() == null) {
			return genreRepo.save(genre);
		} else {
			Optional<Genre> currGenre = genreRepo.findById(genre.getIdGenre());
			if (currGenre.isPresent()) {
				Genre newGenre = currGenre.get();
				newGenre.setGenreName(genre.getGenreName());
				newGenre.setBooks(genre.getBooks());
				return genreRepo.save(newGenre);
			} else {
				return genreRepo.save(genre);
			}
		}
	}

	@Override
	public List<Genre> getAllGenres() {
		return genreRepo.findAll();
	}
}
