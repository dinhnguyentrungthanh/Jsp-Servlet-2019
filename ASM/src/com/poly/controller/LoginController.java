package com.poly.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.bean.User;

@Transactional
@Controller
public class LoginController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("login")
	public String index(ModelMap model) {
		return "login";
	}
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(ModelMap model, 
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession httpSession,
			HttpServletResponse response) {
		
		Session session = factory.getCurrentSession();
		try {
			User user = (User) session.get(User.class, username);
			if(!user.getPassword().equals(password) || !user.isRole() == true){
				model.addAttribute("message","Sai Password hoặc bạn không phải là admin");
				model.addAttribute("DATA", username);
				return "login";
			}
			else{
				response.sendRedirect("admin/index.htm");
				httpSession.setAttribute("USER", user);
			}
		} 
		catch (Exception e) {
			model.addAttribute("message", "Sai tên đăng nhập !");
		}
		
		return "login";
	}
}
