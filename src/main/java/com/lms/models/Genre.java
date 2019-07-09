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

@Entity
public class Genre  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genre_id")
	private Integer idGenre;
	@Column(name = "genre_name")
	private String genreName;

	@OneToMany(mappedBy="booksGenre", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Book> books;

	public Integer getIdGenre() {
		return idGenre;
	}
	
	public void setIdGenre(Integer idGenre) {
		this.idGenre = idGenre;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
