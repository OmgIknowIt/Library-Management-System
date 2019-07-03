package com.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.lms.models.Genre;


public interface GenreRepo extends CrudRepository<Genre,Integer> {
}
