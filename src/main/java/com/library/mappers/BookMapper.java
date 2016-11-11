package com.library.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.library.model.Book;

public interface BookMapper{
	@Select("SELECT * FROM book WHERE (author LIKE #{Author}) AND (name LIKE #{Name}) AND (category LIKE #{Category})")
	public List<Book> searchBook (Book book);
	
	@Select("SELECT * FROM book WHERE (author LIKE #{Author}) AND (name LIKE #{Name}) AND (category LIKE #{Category}) AND (price BETWEEN 0 AND #{Price})")
	public List<Book> searchBookByAll (Book book);
	
	@Select("SELECT * FROM book WHERE id = #{id}")
	public Book selectBookById(String id);
	
	@Update("UPDATE book SET name = #{Name}, category = #{Category}, author = #{Author}, price = #{Price} WHERE id = #{Id} ")
	public void updateBookById(Book book);
	
	@Insert("INSERT INTO library.book (id, name, category, author, price) VALUES (NULL, #{Name}, #{Category}, #{Author}, #{Price})")
	public void insertBookById(Book book);
	
	@Delete("DELETE FROM book WHERE id = #{id}")
	public void deleteBook(String id);
	
}
