package com.library.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.library.service.ReturnService;

@Controller
@RequestMapping(value = "/return")
public class ReturnController {
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView bookList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/return/list");
		return mav;
	}
	
	@RequestMapping(value = "/seachReturn")	
	public  @ResponseBody List<Map<String,Object>> searchReturn (HttpServletRequest request) {
		List<Map<String,Object>> listMapReturn = new ArrayList<>();
		String borrowId = request.getParameter("borrowIdAjax");
		String readerId = request.getParameter("readerIdAjax");
		ReturnService rs = new ReturnService();
		listMapReturn = rs.getReturnById(borrowId, readerId);
		return listMapReturn;
	}
}
