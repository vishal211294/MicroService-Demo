package com.pathtolearnjava.movies.movies.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.kafka.common.message.ConsumerProtocolAssignment.TopicPartitionCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pathtolearnjava.movies.movies.model.Movies;
import com.pathtolearnjava.movies.movies.repo.MoviesRepository;

@RestController
public class MoviesEndpoint {
	private Map<Integer, Movies> movies = new HashMap<>();
	
	@Autowired
	MoviesRepository moviesRepository;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	
	@GetMapping(value = "movies", produces = "application/json")
	public Collection<Movies> getAllMovies() {
		return moviesRepository.findAll();
		//return this.movies.values();
	}
	
	@GetMapping(value = "movies/{id}", produces = "application/json")
	public Movies getMovies(@PathVariable int id) throws NoSuchElementException {
		return moviesRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No Movie with id ["+id+"] found."));
		//return  Optional.ofNullable(movies.get(id)).orElseThrow(() -> new NoSuchElementException("No Movie with id ["+id+"] found."));
	}
	
	@GetMapping(value = "movies-genre/{genre}", produces = "application/json")
	public List<Movies> getMovies(@PathVariable String genre) {
		return moviesRepository.findByGenre(genre);
	}
	
	@GetMapping(value = "search/{movieName}", produces = "application/json")
	public List<Movies> searchMovies(@PathVariable String movieName) {
		return moviesRepository.findByNameContaining(movieName);
	}
	
	@PostMapping(value = "movies" , consumes = "application/json",produces = "application/json")
	public Movies addMovies(@RequestBody Movies movie) throws NoSuchElementException {
		movie.setId(0);
		movie = moviesRepository.save(movie);
		return movies.put(movie.getId(), movie); 
	}
	
	@GetMapping(value = "message/{message}")
	public void message(@PathVariable String message) {
		kafkaTemplate.send("test-1",message);
	}
	
	@KafkaListener(topics = "test-1" , groupId = "test-group-1")
	public void receiveMessage(String message) {
		System.out.println("Sr No. ["+(i++)+"] " +"["+ message+"]");
	}
	
	private static int i = 0;
	
	
}
