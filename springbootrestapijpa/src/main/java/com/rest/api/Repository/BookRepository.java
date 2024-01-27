package com.rest.api.Repository;

import org.springframework.data.repository.CrudRepository;
import com.rest.api.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int userId);
}
