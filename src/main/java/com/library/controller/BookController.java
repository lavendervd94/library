package com.library.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.library.model.Book;
import com.library.service.BookService;
import com.library.service.CategoryService;
import com.library.service.LoadDataService;
import com.library.util.ConstantDefined;

@Controller
@RequestMapping(value = "/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String bookList(Locale locale, HttpServletRequest req, Model model)
			throws  IOException {
		CategoryService cs = new CategoryService();
		model.addAttribute("listCategory", cs.getCategory());
		model.addAttribute("bookList", LoadDataService.getBookList());
		return "/book/list";
	}
	
	@RequestMapping(value = "/searchBook", method = RequestMethod.GET)
	public @ResponseBody List<Book> searchBook(HttpServletRequest request){
 		List<Book> listBook = new ArrayList<>();
		Book book = new Book();
		book.setName("%"+request.getParameter("nameAjax")+"%");
		book.setCategory("%"+request.getParameter("categoryAjax")+"%");
		book.setAuthor("%"+request.getParameter("authorAjax")+"%");
		if(!request.getParameter("priceAjax").equals("")){
			book.setPrice(request.getParameter("priceAjax"));
			listBook = bookService.searchBookAll(book);
		}else{
			listBook = bookService.searchBook(book);
		}
		return listBook;
	}

	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String bookUpdateSelectById(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		CategoryService cs = new CategoryService();
		String mode =null;
		model.addAttribute("listCategory", cs.getCategory());
		if(!("").equals(id) && id!=null){
			mode = ConstantDefined.MODE_EDIT;
			model.addAttribute("mapBookInfo", bookService.selectBookById(id));
			model.addAttribute("id",id);
		}else{
			mode = ConstantDefined.MODE_NEW;
		}
		model.addAttribute("MODE",mode);
		return "/book/update";
	}
	
	@RequestMapping(value= "/updateBook", method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> updateBook(HttpServletRequest request ) {
		Map<String,Object> map = new HashMap<>();
		boolean flag = false;
		Book book = new Book();
		book.setName(request.getParameter("nameAjax"));
		book.setCategory(request.getParameter("categoryAjax"));
		book.setAuthor(request.getParameter("authorAjax"));
		book.setPrice(request.getParameter("priceAjax"));
		book.setId(request.getParameter("id"));
		if(!(book.getId()).equals("")){
			bookService.updateBookById(book);
		}else{
			bookService.insertBookById(book);
		}
		flag = true;
		map.put("success", flag);
		return map;
	}
	@RequestMapping(value= "/deleteBook", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> deleteBook(HttpServletRequest request ) {
		Map<String,Object> map = new HashMap<>();
		boolean flag = false;
		String id = request.getParameter("id");
		bookService.deleteBook(id);
		flag = true;
		map.put("success", flag);
		return map;
	}
}