package com.lms.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "author_id")
	private Integer idAuthors;
	@Column(name = "author_name")
	private String authorName;

	@OneToMany
	//@JoinColumn(name = "id_author")
	private List<Book> authorBooks = new ArrayList<Book>();

	public Author() {
		super();
	}

//	public Author(String authorsName) {
//		super();
//		setAuthorsName(authorName);
//	}

	public Integer getIdAuthors() {
		return idAuthors;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorsName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getAuthorBooks() {
		return authorBooks;
	}

	public void setAuthorBooks(List<Book> authorBooks) {
		this.authorBooks = authorBooks;
	}
}
