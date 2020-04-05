package com.poly.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.apache.catalina.connector.Response;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.bean.User;

@Transactional
@Controller
@RequestMapping("/admin/")
public class UserController {

	@Autowired
	SessionFactory factory;

	@Autowired
	ServletContext context;
	private Response res;

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		return "admin/insert";
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(ModelMap model, @RequestParam String username, @RequestParam String password,
			@RequestParam String fullname, @RequestParam String email, @RequestParam boolean role,
			@RequestParam String phone, @RequestParam("hinh") MultipartFile hinh, HttpServletRequest request) {

		Session session = null;
		Transaction t = null;
		
		if (hinh.isEmpty() || username.equals("") || password.equals("") || fullname.equals("") || email.equals("")
				|| phone.length() == 0 ) {
			model.addAttribute("message", "Vui Lòng Không Để Trống Thông Tin");
			return "admin/insert";
		}
		try {
			session = factory.openSession();
			t = session.beginTransaction();
			// Folder 'images'
			String rootPath = context.getRealPath("images").replace("\\", "//");
			System.out.println(rootPath);
			System.out.println(hinh.getOriginalFilename());

			Path path = Paths.get(rootPath + "//" + hinh.getOriginalFilename());

			Files.write(path, hinh.getBytes());

			// create user
			User u = new User(username, password, fullname, role, email, phone, hinh.getOriginalFilename());

			// Save user
			session.save(u);
			t.commit();
			model.addAttribute("message1", "Thêm mới thành công " + username);
		} catch (Exception e) {
			e.printStackTrace();
			// Violation of PRIMARY KEY constraint 'PK__UserTbl__F3DBC573F5CEC7EB'. Cannot
			// insert duplicate key in object 'dbo.UserTbl'. The duplicate key value is
			// (abc).
			// System.out.println(e.getMessage());
			t.rollback();
			model.addAttribute("message", "Thêm mới thất bại " + username);
			session.close();
		}
		return "admin/insert";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String upate(ModelMap model, @RequestParam String username, @RequestParam String password,
			@RequestParam String fullname, @RequestParam String email, @RequestParam boolean role,
			@RequestParam String phone, @RequestParam("hinh") MultipartFile hinh, HttpServletRequest request) {

		Session session = null;
		Transaction t = null;
		try {
			session = factory.openSession();
			t = session.beginTransaction();
			if (hinh.isEmpty()) {
				model.addAttribute("message2", "Không tìm thấy file !");
				return "admin/update";
			}

			String rootPath = context.getRealPath("images").replace("\\", "//");
			System.out.println(rootPath);
			System.out.println(hinh.getOriginalFilename());

			Path path = Paths.get(rootPath + "//" + hinh.getOriginalFilename());

			Files.write(path, hinh.getBytes());
			User u = new User(username, password, fullname, role, email, phone, hinh.getOriginalFilename());
			session.update(u);
			t.commit();

			model.addAttribute("message1", "Update thành công !" + username);
			Session session1 = factory.getCurrentSession();
			String hql = "FROM User";
			Query query = session1.createQuery(hql);
			List<User> list = query.list();
			model.addAttribute("users", list);
			return "admin/user";
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			model.addAttribute("message", "Update thất bại !" + username);
		} finally {
			session.close();
		}
		return "admin/update";
	}

	@RequestMapping("delete")
	public String insert(ModelMap model, @RequestParam String id,HttpServletResponse response) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			User user = (User) session.get(User.class, id);
			session.delete(user);
			t.commit();
			model.addAttribute("message1", "Xóa Thành Công " + id);
			Session session1 = factory.getCurrentSession();
			String hql = "FROM User";
			Query query = session1.createQuery(hql);
			List<User> list = query.list();
			model.addAttribute("users", list);
			return "admin/user";
			
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Xóa Thất Bại" + id);
		} finally {
			session.close();
		}
		return "admin/user";
	}
	
}
