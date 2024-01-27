package com.rest.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.rest.api.entities.Book;
import com.rest.api.service.Services;

@RestController
public class HomeController {
	@Autowired
	Services service;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> booklist = service.getAllBook();
		if (booklist.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(booklist); 
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getbook(@PathVariable("id") int id) {
		Book book = service.getOneBook(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(book));
		}

	}

	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return service.addBook(book);
	}

	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		service.deleteBook(id);
	}

	@PutMapping("/books/{id}")
	public Book updataBook(@PathVariable("id") int id, @RequestBody Book book) {
		service.updateBook(id, book);
		return book;
	}
}
