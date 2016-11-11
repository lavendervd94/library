package com.library.service;

import java.util.List;

import com.library.model.Reader;

public interface ReaderService {

	List<Reader> getReaderInfo(Reader reader);

	List<Reader> getReaderInfoGender(Reader reader);

	Reader getReaderInfoById(String id);

	void updateReader(Reader reader);
	
	void insertReader(Reader reader);
	
	void deleteReader(String id);
	// public List<Reader> getReaderInfo (String name, String gender, String
	// address,String phone){
	// PreparedStatement ps = null;
	// ResultSet rs = null;
	// Connection conn = null;
	// List<Reader> listReader = new ArrayList<>();
	// try {
	// String sql = null;
	// conn = ConnectDB.getConnection();
	// if (!("").equals(gender)&& gender!=null) {
	// sql = SqlDefined.SQL_SELECT_READER + "AND ( r_gender = ? )";
	// }
	// else{
	// sql = SqlDefined.SQL_SELECT_READER;
	// }
	// ps = (PreparedStatement) conn.prepareStatement(sql);
	// ps.setString(1,"%"+name + "%");
	// ps.setString(2, "%"+address+"%");
	// ps.setString(3, "%"+phone+ "%");
	// if (!("").equals(gender)&& gender!=null) {
	// ps.setString(4,gender);
	// }
	// rs = ps.executeQuery();
	// while (rs.next()){
	// Reader reader = new Reader();
	// reader.setName(rs.getString("r_name"));
	// reader.setGender(rs.getString("r_gender"));
	// reader.setAddress(rs.getString("r_address"));
	// reader.setPhone(rs.getString("r_phone"));
	// reader.setId(rs.getString("r_id"));
	// listReader.add(reader);
	// }
	// return listReader;
	// } catch (Exception e) {
	// e.printStackTrace();
	// return null;
	// }
	// }
	// public Map<String,Object> getReaderInfoById (String id){
	// PreparedStatement ps = null;
	// ResultSet rs = null;
	// Connection conn = null;
	// Map<String,Object> mapReaderInfo = new HashMap<>();
	// try {
	// conn = ConnectDB.getConnection();
	// String sql = SqlDefined.SQL_SELECT_READER_BYID;
	// ps = (PreparedStatement) conn.prepareStatement(sql);
	// ps.setString(1, id);
	// rs = ps.executeQuery();
	// while (rs.next()) {
	// mapReaderInfo.put ("r_name", rs.getString("r_name"));
	// mapReaderInfo.put ("r_gender", rs.getString("r_gender"));
	// mapReaderInfo.put ("r_address", rs.getString("r_address"));
	// mapReaderInfo.put ("r_phone", rs.getString("r_phone"));
	// }
	// return mapReaderInfo;
	// } catch (Exception e) {
	// e.printStackTrace();
	// return null;
	// }
	// }
	// public String updateReader (String name, String gender, String address,
	// String phone, String id){
	// PreparedStatement ps = null;
	// Connection conn = null;
	// try {
	// String sql=null;
	// conn = ConnectDB.getConnection();
	// if(!id.equals("")){
	// sql = SqlDefined.SQL_UPDATE_READER;
	// }
	// else{
	// sql = SqlDefined.SQL_INSERT_READER;
	// }
	// ps = (PreparedStatement) conn.prepareStatement(sql);
	// ps.setString(1, name);
	// ps.setString(2, gender);
	// ps.setString(3, address);
	// ps.setString(4, phone);
	// if (!id.equals("")) {
	// ps.setString(5, id);
	// }
	// ps.executeUpdate();
	// } catch (Exception e) {
	// e.printStackTrace();
	// return null;
	// }
	// return null;
	// }
	// public Boolean deleteReader (String id){
	// PreparedStatement ps = null;
	// Connection conn = null;
	// try {
	// conn = ConnectDB.getConnection();
	// String sql = SqlDefined.SQL_DELETE_READER;
	// ps = (PreparedStatement) conn.prepareStatement(sql);
	// ps.setString(1, id);
	// ps.executeUpdate();
	// return true;
	// } catch (Exception e) {
	// e.printStackTrace();
	// return false;
	// }
	// }
}
