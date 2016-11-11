package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.library.mappers.ReaderMapper;
import com.library.model.Reader;

@Service("readerService")
public class ReaderServiceImpl implements ReaderService {

	@Autowired
	private ReaderMapper readerMapper;
	
	@Transactional
	public List<Reader> getReaderInfo(Reader reader) {
		List<Reader> readerList = readerMapper.searchReaderNotGender(reader);
		return readerList;
	}
	
	public List<Reader> getReaderInfoGender(Reader reader) {
		List<Reader> readerList = readerMapper.searchReaderByAll(reader);
		return readerList;
	}
	public Reader getReaderInfoById(String id) {
		Reader reader = readerMapper.selectById(id);
		return reader;
	}
	
	public void updateReader(Reader reader) {
		readerMapper.updateReader(reader);
	}
	
	public void insertReader(Reader reader) {
		readerMapper.insertReader(reader);
	}
	
	public void deleteReader(String id) {
		readerMapper.deleteReader(id);
	}
}
