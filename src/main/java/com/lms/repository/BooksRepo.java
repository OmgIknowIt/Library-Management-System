package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.models.Books;

public interface BooksRepo extends JpaRepository<Books,Integer>{

}
