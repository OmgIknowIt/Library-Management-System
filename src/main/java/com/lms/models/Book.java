package com.lms.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private Integer idBooks;
	@Column(name = "book_title")
	private String bookTitle;
//	@Column(name = "id_author")
//	private Integer idAuthors;
//	@Column(name = "id_genre")
//	private Integer idGenre;
	@Column(name = "book_year")
	private Integer bookYear;
	@Column(name = "book_description")
	private String bookDescription;
	@Column(name = "book_picture")
	private String bookPicture;
	@Column(name = "book_status")
	private Boolean bookStatus;

	@ManyToOne
	@JoinColumn(name = "id_author")
	private Author booksAuthor;
	@ManyToOne
	@JoinColumn(name = "id_genre")
	private Genre booksGenre;

//	public Book(String bookTitle, Integer idAuthors, Integer idGenre, Integer bookYear, String bookDescription,
//			String bookPicture, Boolean bookStatus) {
//		super();
//		this.bookTitle = bookTitle;
//		this.idAuthors = idAuthors;
//		this.idGenre = idGenre;
//		this.bookYear = bookYear;
//		this.bookDescription = bookDescription;
//		this.bookPicture = bookPicture;
//		this.bookStatus = bookStatus;
//	}

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

//	public Integer getIdAuthor() {
//		return idAuthors;
//	}
//
//	public void setIdAuthor(Integer idAuthor) {
//		this.idAuthors = idAuthor;
//	}
//
//	public Integer getIdGenre() {
//		return idGenre;
//	}
//
//	public void setIdGenre(Integer idGenre) {
//		this.idGenre = idGenre;
//	}

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
