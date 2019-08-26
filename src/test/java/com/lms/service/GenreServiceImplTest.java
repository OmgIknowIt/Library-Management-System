package com.lms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lms.models.Genre;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GenreServiceImplTest {
	@Autowired
	private GenreService genServ;
	final private String GENRE_NAME = "TestGenre";
	final private String NEW_GENRE_NAME = "TestGenreTest";
	
	@Test
	public void getAllGenres() {
		List<Genre> genres = genServ.getAllGenres();
		assertNotNull(genres);
	}
	
	@Test
	public void createOrUpdateGenre() {
		Genre genre = new Genre();
		genre.setGenreName(GENRE_NAME);
		genServ.createOrUpdateGenre(genre);

		Genre a = findGenre(GENRE_NAME);
		
		assertEquals(GENRE_NAME, a.getGenreName());
		
		genre.setGenreName(NEW_GENRE_NAME);
		genServ.createOrUpdateGenre(genre);
		
		a = findGenre(NEW_GENRE_NAME);
		
		assertEquals(NEW_GENRE_NAME, a.getGenreName());
	}
	
	@Test
	public void getGenreTest() {
		List<Genre> genres = genServ.getAllGenres();
		Genre a = genres.get(0);
		Genre b = genServ.getGenre(a.getIdGenre());
		assertEquals(a.getGenreName(), b.getGenreName());
	}
	
	public Genre findGenre(String genreName) {
		List<Genre> genres = genServ.getAllGenres();
		for (int i = genres.size() - 1; i >= 0; i--) {
			System.out.println(genres.get(i).getGenreName());
			if (genres.get(i).getGenreName().equals(genreName)) {
				return genres.get(i);
			}
		}
		return null;
	}
}
