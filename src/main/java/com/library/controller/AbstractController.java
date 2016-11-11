package com.library.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AbstractController {
	public class BorrowController {
		@RequestMapping(value = "/123", method = RequestMethod.GET)
		public ModelAndView bookList(HttpServletRequest req) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/123/123");
			return mav;
		}
	}

}
