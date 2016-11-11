package com.library.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.library.model.Reader;
import com.library.service.ReaderService;

@Controller
@RequestMapping(value = "/dialog")
public class ReaderDialogController {
	
	@Autowired
	private ReaderService readerService;
	
	@RequestMapping(value = "/reader", method = RequestMethod.GET)
	public ModelAndView readerDialog(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/reader/dialog");
		return mav;
	}
	
	@RequestMapping(value = "/searchReader", method = RequestMethod.GET)
	public @ResponseBody  List<Reader> searchReader(HttpServletRequest request) throws IOException {
		List<Reader> listReader = new ArrayList<>();
		Reader reader = new Reader();
		String gender = request.getParameter("genderAjax");
		reader.setName("%" + request.getParameter("nameAjax") + "%");
		reader.setAddress("%" + request.getParameter("addressAjax") + "%");
		reader.setPhone("%" + request.getParameter("phoneAjax") + "%");
		if (gender == null || gender.equals("")) {
			listReader = readerService.getReaderInfo(reader);
		} else {
			reader.setGender(gender);
			listReader = readerService.getReaderInfoGender(reader);
		}
		return listReader;
	}
}
