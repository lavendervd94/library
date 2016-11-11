package com.library.service;

import java.util.List;
import com.library.model.Book;

public interface BookService {
	List<Book> searchBook (Book book);
	List<Book> searchBookAll (Book book);
	Book selectBookById (String id);
	void updateBookById(Book book);
	void insertBookById(Book book);
	void deleteBook(String id);

//	public List<Book> getBookInfo(String name, String category, String author, String price) {
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		Connection conn = null;
//		List<Book> bookList = new ArrayList<Book>();
//		try {
//			conn = ConnectDB.getConnection();
//			String sql = null;
//			if (!price.equals("")) {
//				sql = SqlDefined.SQL_SELECT_BOOK_SEARCH + "AND (price BETWEEN 0 AND ?)";
//			}
//			else{
//				sql = SqlDefined.SQL_SELECT_BOOK_SEARCH;
//			}
//			ps = (PreparedStatement) conn.prepareStatement(sql);
//			ps.setString(1, "%" + name + "%");
//			ps.setString(2, "%" + category + "%");
//			ps.setString(3, "%" + author + "%");
//			if (!price.equals("")) {
//				ps.setInt(4, Integer.parseInt(price));
//			}
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				Book book = new Book();
//				book.setName(rs.getString("name"));
//				book.setCategory(rs.getString("category"));
//				book.setAuthor(rs.getString("author"));
//				book.setPrice(rs.getInt("price"));
//				book.setId(rs.getString("id"));
//				bookList.add(book);
//			}
//			return bookList;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//	public Map<String,Object> getBookInfoById (String id){
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		Connection conn = null;
//		Map<String,Object> mapBookInfo = new HashMap<>();
//		try {
//			conn = ConnectDB.getConnection();
//			String sql = SqlDefined.SQL_EDIT_BOOK;
//			ps = (PreparedStatement) conn.prepareStatement(sql);
//			ps.setString(1, id);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				mapBookInfo.put ("name", rs.getString("name"));
//				mapBookInfo.put ("category", rs.getString("category"));
//				mapBookInfo.put ("author", rs.getString("author"));
//				mapBookInfo.put ("price", rs.getString("price"));
//			}
//			return mapBookInfo;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//	
//	public String updateBook (String name, String category, String author, String price, String id){
//		PreparedStatement ps = null;
//		Connection conn = null;
//		try {
//			String sql=null;
//			conn = ConnectDB.getConnection();
//			if(!id.equals("")){
//				sql = SqlDefined.SQL_UPDATE_BOOK;
//			}
//			else{
//				sql = SqlDefined.SQL_INSERT_BOOK;
//			}
//			ps = (PreparedStatement) conn.prepareStatement(sql);
//			ps.setString(1, name);
//			ps.setString(2, category);
//			ps.setString(3, author);
//			ps.setInt(4, Integer.parseInt(price));
//			if (!id.equals("")) {
//			ps.setString(5, id);
//			}
//			ps.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//		return null;
//	}
//	
//	public Boolean deleteBook (String id){
//		PreparedStatement ps = null;
//		Connection conn = null;
//		try {
//			conn = ConnectDB.getConnection();
//			String sql = SqlDefined.SQL_DELETE_BOOK;
//			ps = (PreparedStatement) conn.prepareStatement(sql);
//			ps.setString(1, id);
//			ps.executeUpdate();
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
}
