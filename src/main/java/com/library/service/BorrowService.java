package com.library.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.util.ConnectDB;
import com.library.util.SqlDefined;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class BorrowService {
	public Integer updateBorrow(String idReader, String dateBorrow, String dateReturn, String checkMode, String idReaderByName, String idBorrowEdit) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		int idBorrow;
		try {
			conn = ConnectDB.getConnection();
			String sql = null;
			if (checkMode.equals("NEW")) {
				sql = SqlDefined.SQL_INSERT_BORROW_READER_ID;
			} else {
				sql = SqlDefined.SQL_UPDATE_BORROW_READER_ID;
			}
			ps = (PreparedStatement) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if (checkMode.equals("NEW")) {
				ps.setString(1, idReader);
				ps.setString(2, dateBorrow);
				ps.setString(3, dateReturn);
			} else {
				ps.setString(1, idReaderByName);
				ps.setString(2, dateBorrow);
				ps.setString(3, dateReturn);
				ps.setString(4, idBorrowEdit);
			}
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			rs.next();
			idBorrow = rs.getInt(1);
			return idBorrow;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void updateBorrowBook(Integer idBorrow, String idBook, String idBorrowEdit, String checkMode) {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			String sql = null;
			conn = ConnectDB.getConnection();
			ObjectMapper mapper = new ObjectMapper();
			List<Map<String, Object>> map = new ArrayList<>();
			map = mapper.readValue(idBook, new TypeReference<List<Map<String, String>>>() {
			});
			for (int i = 0; i < map.size(); i++) {
				sql = SqlDefined.SQL_INSERT_BORROW_BOOK;
				ps = (PreparedStatement) conn.prepareStatement(sql);
				if (checkMode.equals("NEW")) {
					ps.setInt(1, idBorrow);
					ps.setString(2, (String) map.get(i).get("id"));
				} else {
					ps.setString(1, idBorrowEdit);
					ps.setString(2, (String) map.get(i).get("id"));
				}
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getIdReader(String nameReader) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		String IdReaderByName = null;
		try {
			conn = ConnectDB.getConnection();
			String sql = SqlDefined.SQL_SELECT_ID_READER_BORROW;
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, nameReader);
			rs = ps.executeQuery();
			while (rs.next()) {
				IdReaderByName = rs.getString("reader.r_id");
			}
			return IdReaderByName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Map<String, Object>> getBorrowInfo(String nameReader, String dateBorrow, String dateReturn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		List<Map<String, Object>> mapBorrowInfo = new ArrayList<>();
		try {
			conn = ConnectDB.getConnection();
			String sql = SqlDefined.SQL_SELECT_BORROW_SEARCH;
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, "%" + nameReader + "%");
			ps.setString(2, dateBorrow);
			ps.setString(3, dateBorrow);
			ps.setString(4, dateReturn);
			ps.setString(5, dateReturn);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("id", rs.getString("id"));
				map.put("phone", rs.getString("r_phone"));
				map.put("nameReader", rs.getString("r_name"));
				map.put("dateBorrow", rs.getString("date_borrow"));
				map.put("dateReturn", rs.getString("date_return"));
				mapBorrowInfo.add(map);
			}
			return mapBorrowInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, Object> getBorrowInfoById(String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		Map<String, Object> BorrowInfoById = new HashMap<>();
		try {
			conn = ConnectDB.getConnection();
			String sql = SqlDefined.SQL_EDIT_BORROW;
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				BorrowInfoById.put("nameReader", rs.getString("r_name"));
				BorrowInfoById.put("dateBorrow", rs.getString("date_borrow"));
				BorrowInfoById.put("dateReturn", rs.getString("date_return"));
			}
			return BorrowInfoById;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Map<String, Object>> getBookBorrowById(String id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		List<Map<String, Object>> listBookBorrow = new ArrayList<>();
		try {
			conn = ConnectDB.getConnection();
			String sql = SqlDefined.SQL_EDIT_BORROW_BOOK;
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("id", rs.getString("book.id"));
				map.put("name", rs.getString("name"));
				map.put("category", rs.getString("category"));
				map.put("author", rs.getString("author"));
				map.put("price", rs.getString("price"));
				listBookBorrow.add(map);
			}
			return listBookBorrow;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void updateDeleteBorrowBookById(String idBorrowEdit, String checkMode) {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = ConnectDB.getConnection();
			String sql = SqlDefined.SQL_UPDATE_DELETE_BORROW_BOOK;
			if (checkMode.equals("NEW")) {
				ps = (PreparedStatement) conn.prepareStatement(sql);
				ps.setString(1, idBorrowEdit);
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean deleteBorrow(String id) {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = ConnectDB.getConnection();
			String sql = SqlDefined.SQL_DELETE_BORROW;
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
