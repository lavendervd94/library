package com.library.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.library.mappers.BookMapper;
import com.library.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Autowired
	private BookMapper bookMapper;

	@Transactional
	public List<Book> searchBookAll(Book book) {
		List<Book> bookList = bookMapper.searchBookByAll(book);
		return bookList;
	}

	public List<Book> searchBook(Book book) {
		List<Book> bookList = bookMapper.searchBook(book);
		return bookList;
	}

	public Book selectBookById(String id) {
		Book bookList = bookMapper.selectBookById(id);
		return bookList;
	}

	public void updateBookById(Book book) {
		bookMapper.updateBookById(book);
	}

	public void insertBookById(Book book) {
		bookMapper.insertBookById(book);
	}
	
	public void deleteBook(String id) {
		bookMapper.deleteBook(id);
	}
}
