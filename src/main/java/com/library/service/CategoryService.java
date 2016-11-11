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

public class CategoryService {
	public List<Map<String,Object>> getCategory (){
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		List<Map<String,Object>> listCategory = new ArrayList<>();
		try {
			conn = ConnectDB.getConnection();
			String sql = SqlDefined.SQL_SELECT_CATEGORY;
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String a = rs.getString("c_id");
				String b =  rs.getString("c_name");
				Map<String, Object> map = new HashMap<>();
				map.put ("c_id", a);
				map.put ("c_name",b);
				listCategory.add(map);
			}
			return listCategory;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
