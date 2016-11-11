package com.library.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.library.model.Reader;
import com.library.service.ReaderService;
import com.library.util.ConstantDefined;

@Controller
@RequestMapping(value = "/reader")
public class ReaderController {

	@Autowired
	private ReaderService readerService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView readerList(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/reader/list");
		return mav;
	}

	@RequestMapping(value = "/searchReader", method = RequestMethod.GET)
	public @ResponseBody List<Reader> searchReader(HttpServletRequest request) throws IOException {
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
	// @RequestMapping(value = "/searchReader", method = RequestMethod.GET)
	// public @ResponseBody List<Reader> searchReader(HttpServletRequest
	// request) throws IOException {
	// String name = request.getParameter("nameAjax");
	// String gender = request.getParameter("genderAjax");
	// String address = request.getParameter("addressAjax");
	// String phone = request.getParameter("phoneAjax");
	// ReaderService rs = new ReaderService();
	// List<Reader> listReader = new ArrayList<>();
	// listReader=rs.getReaderInfo(name, gender,address,phone);
	// return listReader;
	// }

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateReader(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String mode = null;
		if (!("").equals(id) && id != null) {
			mode = ConstantDefined.MODE_EDIT;
			model.addAttribute("mapReaderInfo", readerService.getReaderInfoById(id));
			model.addAttribute("id", id);
		} else {
			mode = ConstantDefined.MODE_NEW;
		}
		model.addAttribute("MODE", mode);
		return "/reader/update";
	}

	// @RequestMapping(value = "/update", method = RequestMethod.GET)
	// public String updateReader(HttpServletRequest request,Model model){
	// String id = request.getParameter("id");
	// ReaderService rs= new ReaderService();
	// String mode =null;
	// if(!("").equals(id) && id!=null){
	// mode = ConstantDefined.MODE_EDIT;
	// model.addAttribute("mapReaderInfo", rs.getReaderInfoById(id));
	// model.addAttribute("id",id);
	// }else{
	// mode = ConstantDefined.MODE_NEW;
	// }
	// model.addAttribute("MODE",mode);
	// return "/reader/update";
	// }

	@RequestMapping(value = "/updateReader", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> updateReaderById(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		Reader reader = new Reader();
		boolean flag = false;
		reader.setName(request.getParameter("name"));
		reader.setGender(request.getParameter("gender"));
		reader.setAddress(request.getParameter("address"));
		reader.setPhone(request.getParameter("phone"));
		reader.setId(request.getParameter("id"));
		if (!(reader.getId()).equals("")) {
			readerService.updateReader(reader);
		} else {
			readerService.insertReader(reader);
		}
		flag = true;
		map.put("success", flag);
		return map;
	}

	// @RequestMapping(value= "/updateReaderById", method=RequestMethod.GET)
	// @ResponseBody
	// public Map<String,Object> updateReaderById(HttpServletRequest request ) {
	// Map<String,Object> map = new HashMap<>();
	// boolean flag = false;
	// ReaderService rs= new ReaderService();
	// String name = request.getParameter("name");
	// String gender = request.getParameter("gender");
	// String address = request.getParameter("address");
	// String phone = request.getParameter("phone");
	// String id = request.getParameter("id");
	// rs.updateReader(name, gender, address, phone, id);
	// flag = true;
	// map.put("success", flag);
	// return map;
	// }

	@RequestMapping(value = "/deleteReader", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteReader(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		boolean flag = false;
		String id = request.getParameter("id");
		readerService.deleteReader(id);
		flag = true;
		map.put("success", flag);
		return map;
	}

	// @RequestMapping(value= "/deleteReader", method=RequestMethod.GET)
	// @ResponseBody
	// public Map<String,Object> deleteReader(HttpServletRequest request ) {
	// Map<String,Object> map = new HashMap<>();
	// String id = request.getParameter("id");
	// ReaderService rs= new ReaderService();
	// map.put("success", rs.deleteReader(id));
	// return map;
	// }
}
