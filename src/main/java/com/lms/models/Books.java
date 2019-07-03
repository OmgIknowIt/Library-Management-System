package com.lms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idBooks;
	private String bookTitle;
	private int idAuthors;
	private int idGenre;
	private int bookYear;
	private String bookDescription;
	private String bookPicture;
	private boolean bookStatus;

	public Books() {
	}

	public Books(String bookTitle, int idAuthor, int idGenre, int bookYear, String bookDescr, String linkToPicture,
			boolean bookStatus) {
		this.bookTitle = bookTitle;
		this.idAuthors = idAuthor;
		this.idGenre = idGenre;
		this.bookYear = bookYear;
		this.bookDescription = bookDescr;
		this.bookPicture = linkToPicture;
		this.bookStatus = bookStatus;
	}

	public int getIdBook() {
		return idBooks;
	}

	public String getbookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getIdAuthor() {
		return idAuthors;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthors = idAuthor;
	}

	public int getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}

	public int getBookYear() {
		return bookYear;
	}

	public void setBookYear(int bookYear) {
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

	public boolean isBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(boolean bookStatus) {
		this.bookStatus = bookStatus;
	}
}
