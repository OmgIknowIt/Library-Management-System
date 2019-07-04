package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.lms.models.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
