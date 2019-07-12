package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.models.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {
}
