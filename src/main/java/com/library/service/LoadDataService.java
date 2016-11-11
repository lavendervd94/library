package com.library.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Book;
import com.library.util.ConnectDB;
import com.library.util.SqlDefined;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class LoadDataService {
	public static List<Book> getBookList() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			List<Book> bookList = new ArrayList<Book>();
			conn = ConnectDB.getConnection();
			String sql = SqlDefined.SQL_SELECT_BOOK;
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				bookList.add(new Book(rs.getString("name"), rs.getString("category"), rs.getString("author"),
						rs.getString("price"),rs.getString("id")));
			}
			return bookList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
