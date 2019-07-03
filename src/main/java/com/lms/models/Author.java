package com.lms.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idAuthors")
	private Integer idAuthors;
	@Column(name = "authorName")
	private String authorName;

	public Author() {

	}

	public Author(String authorsName) {
		setAuthorsName(authorName);
	}

	public Integer getIdAuthors() {
		return idAuthors;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorsName(String authorName) {
		this.authorName = authorName;
	}
}
