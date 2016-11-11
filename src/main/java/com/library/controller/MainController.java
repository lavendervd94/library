//package com.library.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class MainController {
//	@RequestMapping(value = "/main", method = RequestMethod.GET)
//	public String login(HttpServletRequest req) {
//		HttpSession session = req.getSession();
//		if((String) session.getAttribute("username")==null){
//			return "redirect:login";
//		}
//		return "main";
//	}
//}
