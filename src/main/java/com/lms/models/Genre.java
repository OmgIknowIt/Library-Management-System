package com.lms.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idGenre;
	
	private String genreName;
	
	public Genre() {
		super();
	}

	public Genre(String genre) {
		super();
		setGenreName(genre);
	}
	
	public int getIdGenre() {
		return idGenre;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
}
