package com.library.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.library.service.BorrowService;
import com.library.util.ConstantDefined;

@Controller
@RequestMapping(value = "/borrow")
public class BorrowController {
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView bookList(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/borrow/list");
		return mav;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateBorrow(HttpServletRequest request, Model model) throws IOException {
		String id = request.getParameter("id");
		String mode =null;
		BorrowService bs = new BorrowService();
		if(!("").equals(id) && id!=null){
			mode = ConstantDefined.MODE_EDIT;
			model.addAttribute("listBorrow",bs.getBorrowInfoById(id));
			model.addAttribute("listBookBorrow",bs.getBookBorrowById(id));
			model.addAttribute("id",id);
		}else{
			mode = ConstantDefined.MODE_NEW;
		}
		model.addAttribute("MODE",mode);
		return "/borrow/update";
	}
	
	@RequestMapping(value = "/searchBorrow", method = RequestMethod.GET)
	public @ResponseBody List<Map<String,Object>> searchBorrow(HttpServletRequest request) throws IOException {
		String nameReader = request.getParameter("nameReaderAjax");
		String dateBorrow = request.getParameter("dateBorrowAjax");
		String dateReturn = request.getParameter("dateReturnAjax"); 
		List<Map<String,Object>> borrowList = new ArrayList<>();		
		BorrowService bs = new BorrowService();
		borrowList = bs.getBorrowInfo(nameReader, dateBorrow, dateReturn);
		return borrowList;
	}
	
	@RequestMapping(value = "/updateBorrow", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> addBorrow(HttpServletRequest request) throws IOException {
		Map<String,Object> map = new HashMap<>();
		boolean flag = false;
		Integer idBorrow = null;
		String idReaderByName = null;
 		String idReader = request.getParameter("idReaderAjax");
 		String nameReader = request.getParameter("nameReaderAjax");
		String dateBorrow = request.getParameter("dateBorrowAjax");
		String dateReturn = request.getParameter("dateReturnAjax");
		String idBook = request.getParameter("listIdBookSentAjax");
		String checkMode = request.getParameter("checkModeAjax");
		String idBorrowEdit = request.getParameter("idBorrowAjax");
		BorrowService bs = new BorrowService();
		idReaderByName = bs.getIdReader(nameReader);
		idBorrow = bs.updateBorrow(idReader, dateBorrow, dateReturn,checkMode,idReaderByName,idBorrowEdit);
		bs.updateDeleteBorrowBookById(idBorrowEdit,checkMode);
		bs.updateBorrowBook(idBorrow, idBook , idBorrowEdit, checkMode);
		flag = true;
		map.put("success", flag);
		return map;
	}
	@RequestMapping(value= "/deleteBorrow", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> deleteBorrow(HttpServletRequest request ) {
		Map<String,Object> map = new HashMap<>();
		String id = request.getParameter("id");
		BorrowService bs = new BorrowService();
		map.put("success", bs.deleteBorrow(id));
		return map;
	}
}
