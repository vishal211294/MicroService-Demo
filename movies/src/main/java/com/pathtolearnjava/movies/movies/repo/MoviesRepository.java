package com.pathtolearnjava.movies.movies.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pathtolearnjava.movies.movies.model.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer> {
	List<Movies> findByGenre(String genre);
	List<Movies> findByNameContaining(String name);
}
