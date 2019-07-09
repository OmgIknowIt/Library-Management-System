package com.lms.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Integer idBooks;
	@Column(name = "book_title")
	private String bookTitle;
	@Column(name = "book_year")
	private Integer bookYear;
	@Column(name = "book_description")
	private String bookDescription;
	@Column(name = "book_picture")
	private String bookPicture;
	@Column(name = "book_status")
	private Boolean bookStatus;

	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_author")
	private Author booksAuthor;
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "id_genre")
	private Genre booksGenre;

	public void setIdBooks(Integer idBooks) {
		this.idBooks = idBooks;
	}

	public Integer getIdBooks() {
		return idBooks;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public Integer getBookYear() {
		return bookYear;
	}

	public void setBookYear(Integer bookYear) {
		this.bookYear = bookYear;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookPicture() {
		return bookPicture;
	}

	public void setBookPicture(String linkToPicture) {
		this.bookPicture = linkToPicture;
	}

	public Boolean getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(Boolean bookStatus) {
		this.bookStatus = bookStatus;
	}

	public Author getBooksAuthor() {
		return booksAuthor;
	}

	public void setBooksAuthor(Author booksAuthor) {
		this.booksAuthor = booksAuthor;
	}

	public Genre getBooksGenre() {
		return booksGenre;
	}

	public void setBooksGenre(Genre booksGenre) {
		this.booksGenre = booksGenre;
	}
}
