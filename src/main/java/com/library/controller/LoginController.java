package com.library.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.library.authinterceptor.Auth;
import com.library.entity.UserInfo;
import com.library.service.AccountService;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session) {
		if (session.getAttribute("isLogin") != null && (Boolean) session.getAttribute("isLogin") == true) {
			return "redirect:/main";
		}
		return "login";
	}
	
	/*@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		ModelAndView mav = new ModelAndView();
		String username = null;
		if (session != null) {
			username = (String) session.getAttribute("username");
			if (username != null) {
				return new ModelAndView("redirect:main");
			}
			else{
				mav.setViewName("login");
				return mav;
			}
		}
		mav.setViewName("login");
		return mav;
	}*/
	
	@RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
	public String checkLogin(HttpServletRequest req, HttpServletResponse response, HttpSession session) throws SQLException, IOException {
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		if ("123123".equals(pass)) {
			if ("mjsakju1".equals(user)) {
				session.setAttribute("isLogin", true);
				session.setAttribute("user", user);
				session.setAttribute("role", Auth.Role.ADMIN);
				return "redirect:/main";
			} else if ("dungth94".equals(user)) {
				session.setAttribute("isLogin", true);
				session.setAttribute("user", user);
				session.setAttribute("role", Auth.Role.EMPLOYEE);
				return "redirect:/main";
			}
		}
		return "login";
		/*ModelAndView model = new ModelAndView();
		HttpSession session = req.getSession();
		if((String) session.getAttribute("username")!=null){
			return new ModelAndView("redirect:main");
		}
		AccountService accountService = new AccountService();
		UserInfo userInfo = accountService.getUserInfor(username, password);
		if(userInfo!=null){
			session.setAttribute("username", userInfo.getUsername());
			return new ModelAndView("redirect:main");
		}else{
			username = (String) session.getAttribute("username");
			model.addObject("message", "Username or password not exist");
			return new ModelAndView("redirect:login");
		}*/
	}
	
	@Auth(role = Auth.Role.LOGIN)
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("isLogin");
		session.removeAttribute("user");
		session.removeAttribute("role");
		return "redirect:/login";
	}
	
	@Auth(role = Auth.Role.LOGIN)
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String needLogin() {
		return "main";
	}
	
	@RequestMapping(value = "/authorities", method = RequestMethod.GET)
	public String authorities() {
		return "authorities";
	}
	
	@Auth(role = Auth.Role.ADMIN)
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}
	
	@Auth(role = Auth.Role.EMPLOYEE)
	@RequestMapping(value = "/emp", method = RequestMethod.GET)
	public String employee() {
		return "emp";
	}
}