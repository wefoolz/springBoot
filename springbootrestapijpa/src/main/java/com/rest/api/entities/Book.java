package com.rest.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	private int bookId;
	private String bookName;
	private String bookTitle;
	
	public Book(int bookId, String bookName, String bookTitle) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookTitle = bookTitle;
	}
	public Book(String bookName, String bookTitle) {
		super();
		this.bookName = bookName;
		this.bookTitle = bookTitle;
	}
	public Book(int bookId) {
		super();
		this.bookId = bookId;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookTitle=" + bookTitle + "]";
	}
	
	
}
