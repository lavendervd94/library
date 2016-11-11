package com.library.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.library.model.Book;
import com.library.service.BookService;
import com.library.service.CategoryService;

@Controller
@RequestMapping(value = "/dialog")
public class BookDialogController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public ModelAndView bookDialog(HttpServletRequest request) {
		CategoryService cs = new CategoryService();
		ModelAndView mav = new ModelAndView();
		mav.addObject("listCategory", cs.getCategory());
		mav.addObject("data", request.getParameter("data"));
		mav.setViewName("/book/dialog");
		return mav;

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
}