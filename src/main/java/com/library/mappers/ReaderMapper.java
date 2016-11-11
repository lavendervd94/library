package com.library.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.library.model.Reader;

public interface ReaderMapper {

	@Select("SELECT r_name as name, r_address as address, r_phone as phone, r_gender as gender, r_id as id FROM reader WHERE (r_name LIKE #{Name}) AND (r_address LIKE #{Address}) AND (r_phone LIKE #{Phone})")
	public List<Reader> searchReaderNotGender(Reader reader);

	@Select("SELECT r_name as name, r_address as address, r_phone as phone, r_gender as gender, r_id as id FROM reader WHERE (r_name LIKE #{Name}) AND (r_address LIKE #{Address}) AND (r_phone LIKE #{Phone}) AND (r_gender = #{Gender})")
	public List<Reader> searchReaderByAll(Reader reader);

	@Select("SELECT r_name as name, r_address as address, r_phone as phone, r_gender as gender FROM reader WHERE r_id = #{id}")
	public Reader selectById(String id);

	@Update("UPDATE reader SET r_name = #{Name}, r_gender = #{Gender}, r_address = #{Address}, r_phone = #{Phone} WHERE r_id = #{Id} ")
	public void updateReader(Reader reader);

	@Insert("INSERT INTO library.reader (r_id, r_name, r_gender, r_address, r_phone) VALUES (NULL, #{Name}, #{Gender}, #{Address}, #{Phone})")
	public void insertReader(Reader reader);
	
	@Delete("DELETE FROM reader WHERE r_id = #{id}")
	public void deleteReader(String id);
}
