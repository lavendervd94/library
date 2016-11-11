package com.library.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.library.util.ConnectDB;
import com.library.util.SqlDefined;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ReturnService {
	
	public List<Map<String,Object>> getReturnById (String borrowId, String readerId){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		List<Map<String, Object>> listMapReturn = new ArrayList<>();
		try {
			conn = ConnectDB.getConnection();
			String sql = SqlDefined.SQL_SELECT_ALL_RETURN;
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, borrowId);
			ps.setString(2, readerId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<>();
				map.put("borrowID",rs.getString("borrow_id"));
				map.put("nameReader",rs.getString("r_name"));
				map.put("bookName",rs.getString("name"));
				map.put("dataReturnReality",rs.getString("date_return_reality_convert"));
				map.put("status",rs.getString("status_borrow"));
				listMapReturn.add(map);
			}
			return listMapReturn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
