package com.lms.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.lms.models.Author;
import com.lms.models.Book;
import com.lms.models.Genre;
import com.lms.repository.AuthorRepo;
import com.lms.repository.BooksRepo;
import com.lms.repository.GenreRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BookServiceImplTest {

	@Autowired
	private BookService bookImpl;
	@Autowired
	private AuthorService authImpl;
	@Autowired
	private GenreService genreImpl;
	
	private final String BOOK_TITLE = "TestTitle";
	private final Integer BOOK_YEAR = 2019;
	private final String DESCIRPTION = "TextTextTextText";
	private final String AUTHOR_NAME = "TestAuthor";
	private final String GENRE_NAME = "TestGenre";
	
	@Test
	public void getAllBooks() {
		List<Book> books = bookImpl.getAllBooks();
		assertNotNull(books);
	}
	
	@Test
	public void createOrUpdateBook() {
		Book book = new Book();
		book.setBookTitle(BOOK_TITLE);
		book.setBookYear(BOOK_YEAR);
		book.setBookDescription(DESCIRPTION);
		book.setBookStatus(true);
		
		Author author = new Author();
		author.setAuthorName(AUTHOR_NAME);
		authImpl.createOrUpdateAuthor(author);
		book.setBooksAuthor(author);
		
		Genre genre = new Genre();
		genre.setGenreName(GENRE_NAME);
		genreImpl.createOrUpdateGenre(genre);
		book.setBooksGenre(genre);
		
		bookImpl.createOrUpdateBook(book);
		
		Book b = findBook(BOOK_TITLE);
		assertNotNull(b);
		assertEquals(BOOK_TITLE, b.getBookTitle());
		assertEquals(AUTHOR_NAME, b.getBooksAuthor().getAuthorName());
		assertEquals(GENRE_NAME, b.getBooksGenre().getGenreName());
	}
	
	@Test
	public void getBook() {
		List<Book> books = bookImpl.getAllBooks();
		Book a = books.get(0);
		Book b = bookImpl.getBook(a.getIdBooks());
		assertEquals(a.getBookTitle(), b.getBookTitle());		
	}
	
	@Test
	public void deleteBook() {
		List<Book> orignal_books = bookImpl.getAllBooks();
		Book a = orignal_books.get(0);
		bookImpl.deleteBook(a.getIdBooks());
		List<Book> changed_books = bookImpl.getAllBooks();
		Book b = changed_books.get(0);
		assertTrue(orignal_books.size() > changed_books.size());
		assertNotEquals(a.getBookTitle(), b.getBookTitle());
	}
	
	public Book findBook(String bookName) {
		List<Book> books = bookImpl.getAllBooks();
		for (int i = books.size() - 1; i >= 0; i--) {
			if (books.get(i).getBookTitle().equals(bookName)) {
				return books.get(i);
			}
		}
		return null;
	}

}
