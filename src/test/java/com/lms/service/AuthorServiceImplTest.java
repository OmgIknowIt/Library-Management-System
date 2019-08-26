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

import com.lms.models.Author;
import com.lms.models.Genre;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AuthorServiceImplTest {

	@Autowired
	private AuthorService autServ;
	final private String AUTHOR_NAME = "TestAuthor";
	final private String NEW_AUTHOR_NAME = "TestAuthorTest";
	
	@Test
	public void getAllAuthorsTest() {
		assertNotNull(autServ.getAllAuthors());
	}

	@Test
	public void createOrUpdateAuthorTest() {
		Author author = new Author();
		author.setAuthorName(AUTHOR_NAME);
		autServ.createOrUpdateAuthor(author);

		Author a = findAuthor(AUTHOR_NAME);
		
		assertEquals(AUTHOR_NAME, a.getAuthorName());
		
		author.setAuthorName(NEW_AUTHOR_NAME);
		autServ.createOrUpdateAuthor(author);
		
		a = findAuthor(NEW_AUTHOR_NAME);
		
		assertEquals(NEW_AUTHOR_NAME, a.getAuthorName());

	}
	
	@Test
	public void getAuthorTest() {
		List<Author> authors = autServ.getAllAuthors();
		Author a = authors.get(0);
		Author b = autServ.getAuthor(a.getIdAuthors());
		assertEquals(a.getAuthorName(), b.getAuthorName());
	}
	
	public Author findAuthor(String authorName) {
		List<Author> auths = autServ.getAllAuthors();
		for (int i = auths.size() - 1; i >= 0; i--) {
			System.out.println(auths.get(i).getAuthorName());
			if (auths.get(i).getAuthorName().equals(authorName)) {
				return auths.get(i);
			}
		}
		return null;
	}
}
