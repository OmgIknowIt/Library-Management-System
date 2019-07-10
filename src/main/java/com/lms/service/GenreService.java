package com.lms.service;

import java.util.List;

import com.lms.models.Genre;

public interface GenreService {
	public void addGenre(Genre genre);

	public Genre getGenre(Integer idGenre);

	public Genre createOrUpdateGenre(Genre genre);

	public List<Genre> getAllGenres();
}
