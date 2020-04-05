package com.poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.bean.User;

@Transactional
@Controller
@RequestMapping("/admin/")
public class IndexController {
	@Autowired
	SessionFactory factory;

	@RequestMapping("user")
	public String index(ModelMap model) {
		Session session1 = factory.getCurrentSession();
		String hql = "FROM User";
		Query query = session1.createQuery(hql);
		List<User> list = query.list();
		model.addAttribute("users", list);
		return "admin/user";
	}

	@RequestMapping("update")
	public String update(ModelMap model, @RequestParam String id) {
		try {
			Session session2 = factory.getCurrentSession();
			User user = (User) session2.get(User.class, id);

			model.addAttribute("userss", user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "admin/update";
	}
	
	
	@RequestMapping("couttype")
	public String report(ModelMap model) {
	Session session = factory.getCurrentSession();
	String hql = "SELECT staff.id, "+
	" SUM(case when type=1 then 1 else 0 end), "+
	" SUM(case when type=0 then 1 else 0 end)"+
	" FROM Record  "+
	" GROUP BY staff.id";

	Query query = session.createQuery(hql);
	System.out.println(hql);
	List<Object[]> list = query.list();
	model.addAttribute("arrays", list);
	return "admin/couttype";
	}
	
	@RequestMapping("index")
	public String report1(ModelMap model) {
		Session session2 = factory.getCurrentSession();
		String hql = 
		" SELECT SUM(case when type=1 then 1 else 0 end), "+
		" SUM(case when type=0 then 1 else 0 end)"+
		" FROM Record"+
		" GROUP BY type";		
		Query query = session2.createQuery(hql);
		System.out.println(hql);
		 List<String[]> list = query.list();
			 model.addAttribute("arrayss", list.get(1));
			 model.addAttribute("arraysss", list.get(0));
		return "admin/index";
	}
	
}
