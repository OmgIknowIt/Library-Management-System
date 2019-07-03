package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.models.Genre;


public interface GenreRepo extends JpaRepository<Genre,Integer> {

}
