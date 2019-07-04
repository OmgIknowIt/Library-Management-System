package com.lms.models;

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
	private Integer idAuthors;
	private String authorName;

	public Author() {
		super();
	}

	public Author(String authorsName) {
		super();
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
