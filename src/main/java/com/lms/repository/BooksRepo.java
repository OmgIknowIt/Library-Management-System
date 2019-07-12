package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.models.Book;

public interface BooksRepo extends JpaRepository<Book, Integer> {
}
