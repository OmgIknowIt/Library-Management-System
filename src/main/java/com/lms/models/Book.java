package com.lms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idBooks;
	private String bookTitle;
	private Integer idAuthors;
	private Integer idGenre;
	private Integer bookYear;
	private String bookDescription;
	private String bookPicture;
	private Boolean bookStatus;

//	@OneToMany
//	private Collection<Author> authors = new ArrayList<Author>();
//	@OneToMany
//	private Collection<Genre> genre = new ArrayList<Genre>();

	public Book(String bookTitle, Integer idAuthors, Integer idGenre, Integer bookYear, String bookDescription,
			String bookPicture, Boolean bookStatus) {
		super();
		this.bookTitle = bookTitle;
		this.idAuthors = idAuthors;
		this.idGenre = idGenre;
		this.bookYear = bookYear;
		this.bookDescription = bookDescription;
		this.bookPicture = bookPicture;
		this.bookStatus = bookStatus;
	}
	
	public Book() {
		super();
	}

	public Integer getIdBook() {
		return idBooks;
	}

	public String getbookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Integer getIdAuthor() {
		return idAuthors;
	}

	public void setIdAuthor(Integer idAuthor) {
		this.idAuthors = idAuthor;
	}

	public Integer getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(Integer idGenre) {
		this.idGenre = idGenre;
	}

	public Integer getBookYear() {
		return bookYear;
	}

	public void setBookYear(Integer bookYear) {
		this.bookYear = bookYear;
	}

	public String getBookDescr() {
		return bookDescription;
	}

	public void setBookDescr(String bookDescr) {
		this.bookDescription = bookDescr;
	}

	public String getbookPicture() {
		return bookPicture;
	}

	public void setbookPicture(String linkToPicture) {
		this.bookPicture = linkToPicture;
	}

	public Boolean isBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(Boolean bookStatus) {
		this.bookStatus = bookStatus;
	}
}
