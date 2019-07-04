package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.lms.models.Book;

public interface BooksRepo extends JpaRepository<Book, Integer> {
}
