package com.rest.api.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.Repository.BookRepository;
import com.rest.api.entities.Book;

@Service
public class Services {
    @Autowired
    BookRepository bookrepository;
    
	public List<Book> getAllBook() {
		List<Book> allBook = (List<Book>)bookrepository.findAll();
		return allBook;
	}

	public Book getOneBook(int id) {
		Book book = null;
		try {
		book = bookrepository.findById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return book;
	}

	public Book addBook(Book book) {
		Book bookk=null;
		try {
			bookk = bookrepository.save(book);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bookk;
	}

	public void deleteBook(int id) {
		try {
			bookrepository.deleteById(null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	public void updateBook(int id, Book book) {
		
		try {
			book.setBookId(id);
			bookrepository.save(book);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
