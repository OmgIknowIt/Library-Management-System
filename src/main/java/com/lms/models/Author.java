package com.lms.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
	private Integer idAuthors;
	@Column(name = "author_name")
	private String authorName;

	@OneToMany(mappedBy="booksAuthor", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Book> books;

	public Integer getIdAuthors() {
		return idAuthors;
	}
	
	public void setIdAuthors(Integer idAuthors) {
		this.idAuthors = idAuthors;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
