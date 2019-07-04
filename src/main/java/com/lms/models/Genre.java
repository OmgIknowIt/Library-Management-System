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

@Entity
public class Genre  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "genre_id")
	private int idGenre;
	@Column(name = "genre_name")
	private String genreName;

	@OneToMany
	//@JoinColumn(name = "id_genre")
	private List<Book> booksGenre = new ArrayList<Book>();

	public Genre() {
		super();
	}

//	public Genre(String genre) {
//		super();
//		setGenreName(genre);
//	}

	public int getIdGenre() {
		return idGenre;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public List<Book> getBooksGenre() {
		return booksGenre;
	}

	public void setBooksGenre(List<Book> booksGenre) {
		this.booksGenre = booksGenre;
	}
}
