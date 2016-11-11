package com.library.service;

import java.sql.ResultSet;
import com.library.entity.UserInfo;
import com.library.util.ConnectDB;
import com.library.util.SqlDefined;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class AccountService {
	public UserInfo getUserInfor(String username, String password){
		UserInfo userInfo = new UserInfo();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = ConnectDB.getConnection();
			String sql = SqlDefined.SQL_SELECT_CHECK_LOGIN_ACCOUNT;
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				userInfo.setUsername(rs.getString("username"));
			}
			return userInfo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
