package com.library.util;

public class SqlDefined {
	public static String SQL_SELECT_CHECK_LOGIN_ACCOUNT = "SELECT * FROM account where username = ? and password = ?";

	public static String SQL_SELECT_BOOK = "SELECT * FROM book";
	public static String SQL_EDIT_BOOK = "SELECT * FROM book where id = ? ";
	public static String SQL_SELECT_BOOK_SEARCH = "SELECT * FROM book where (name LIKE ?) AND (category LIKE ?) AND (author LIKE ?)";
	public static String SQL_SELECT_BOOK1 = "SELECT * FROM book ";
	public static String SQL_UPDATE_BOOK = "UPDATE book SET name= ?,category = ?,author = ?,price = ? WHERE id = ? ";
	public static String SQL_INSERT_BOOK = "INSERT INTO library.book (id, name, category, author, price) VALUES (NULL, ?, ?, ?, ?);";
	public static String SQL_DELETE_BOOK = "DELETE FROM book WHERE id = ?";

	public static String SQL_SELECT_READER = "SELECT * FROM reader where (r_name LIKE ?) AND (r_address LIKE ? ) AND (r_phone LIKE ? )";
	public static String SQL_SELECT_READER_BYID = "SELECT *FROM reader where r_id = ? ";
	public static String SQL_UPDATE_READER = "UPDATE reader SET r_name = ?,r_gender = ?, r_address = ? ,r_phone = ? WHERE r_id = ? ";
	public static String SQL_INSERT_READER = "INSERT INTO library.reader (r_id, r_name, r_gender, r_address, r_phone) VALUES (NULL, ?, ?, ?, ?);";
	public static String SQL_DELETE_READER = "DELETE FROM reader WHERE r_id = ?";

	public static String SQL_SELECT_CATEGORY = "SELECT * FROM category";

	public static String SQL_INSERT_BORROW_READER_ID = "INSERT INTO borrow (r_id, date_borrow, date_return) VALUES ( ?, STR_TO_DATE(?,'%Y/%m/%d'),STR_TO_DATE(?,'%Y/%m/%d'))";
	public static String SQL_INSERT_BORROW_BOOK = "INSERT INTO library.borrow_book (borrow_id, book_id) VALUES( ? , ? )";
	public static String SQL_SELECT_BORROW_SEARCH = "SELECT borrow.id,reader.r_name,reader.r_phone, borrow.date_borrow, borrow.date_return FROM borrow INNER JOIN reader ON borrow.r_id = reader.r_id WHERE 1=1 AND (r_name LIKE ? ) AND (date_borrow = ?  OR  ? = '') AND (date_return = ? OR ? = '')";
	public static String SQL_DELETE_BORROW = "DELETE FROM borrow WHERE id = ?";
	public static String SQL_SELECT_BORROW_READER_ID = "SELECT borrow.id FROM borrow WHERE borrow.r_id = ?";
	public static String SQL_EDIT_BORROW_BOOK  = "SELECT * FROM borrow INNER JOIN reader ON borrow.r_id = reader.r_id INNER JOIN borrow_book ON borrow.id = borrow_book.borrow_id INNER JOIN book ON borrow_book.book_id = book.id WHERE  borrow.id = ?";
	public static String SQL_EDIT_BORROW = "SELECT * FROM borrow INNER JOIN reader ON borrow.r_id = reader.r_id INNER JOIN borrow_book ON borrow.id = borrow_book.borrow_id INNER JOIN book ON borrow_book.book_id = book.id WHERE  borrow.id = ?";
	public static String SQL_UPDATE_BORROW_READER_ID = "UPDATE  borrow SET r_id = ?, date_borrow = ?, date_return = ? WHERE id = ? ";
	public static String SQL_UPDATE_DELETE_BORROW_BOOK = "DELETE FROM borrow_book WHERE borrow_id = ?";
	public static String SQL_SELECT_ID_READER_BORROW  = "SELECT *  FROM borrow INNER JOIN reader ON borrow.r_id = reader.r_id WHERE r_name = ? ";
	
	public static String SQL_SELECT_ALL_RETURN = "SELECT a.borrow_id, c.r_name, e. NAME, d.status_borrow, d.date_return_reality, CASE WHEN d.date_return_reality <> '0000-00-00' THEN d.date_return_reality ELSE NULL END AS date_return_reality_convert FROM return_book a INNER JOIN borrow b ON a.borrow_id = b.id INNER JOIN reader c ON b.r_id = c.r_id INNER JOIN borrow_book d ON b.id = d.borrow_id INNER JOIN book e ON d.book_id = e.id WHERE (a.borrow_id = ?) OR (b.r_id = ?)";
}
