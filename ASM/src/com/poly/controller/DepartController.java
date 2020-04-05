package com.poly.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.bean.Depart;


@Controller
@Transactional
@RequestMapping("/admin/")
public class DepartController {
	@Autowired
	SessionFactory factory;

	public String depart() {
		return "admin/depart";
	}

	@RequestMapping("depart")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Depart";
		Query query = session.createQuery(hql);
		List<Depart> list = query.list();
		model.addAttribute("departs", list);
		return "admin/depart";
	}

	@RequestMapping("update-depart")
	public String update(ModelMap model, @RequestParam String id) {
		try {
			Session session2 = factory.getCurrentSession();
			Depart depart = (Depart) session2.get(Depart.class, id);

			model.addAttribute("departss", depart);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "admin/update-depart";
	}

	@RequestMapping(value = "insert-depart", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("depart", new Depart());
		return "admin/insert-depart";
	}

	@RequestMapping(value = "insert-depart", method = RequestMethod.POST)
	public String insert(ModelMap model, @Validated @ModelAttribute("depart") Depart depart, BindingResult errors) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		if(depart.getId().trim().length() == 0) {
			errors.rejectValue("id","depart","Vui Lòng không để trống");
		}
		if(depart.getName().trim().length() == 0) {
			errors.rejectValue("name", "depart", "Vui lòng không đê trống");
		}
		try {
			session.save(depart);
			t.commit();
			model.addAttribute("message1", "Thêm mới thành công " + depart.getId());
			
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message2", "Thêm mới thất bại !"+ depart.getId());
		} finally {
			session.close();
		}
		return "admin/insert-depart";
	}
	
	@RequestMapping(value = "update-depart", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("departss") Depart depart) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(depart);
			t.commit();
			model.addAttribute("message1", "Sửa mới thành công " + depart.getId());
			Session session1 = factory.getCurrentSession();
			String hql = "FROM Depart";
			Query query = session.createQuery(hql);
			List<Depart> list = query.list();
			model.addAttribute("departs", list);
			return "admin/depart";
			
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message2", "Sửa mới thất bại !"+ depart.getId());
		} finally {
			session.close();
		}
		return "admin/insert-depart";
	}

	@RequestMapping("delete-depart")
	public String insert(ModelMap model, @RequestParam String id) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Depart depart = (Depart) session.get(Depart.class, id);
			session.delete(depart);
			t.commit();
			model.addAttribute("message1", "Xóa Thành Công " + id);
			Session session1 = factory.getCurrentSession();
			String hql = "FROM Depart";
			Query query = session.createQuery(hql);
			List<Depart> list = query.list();
			model.addAttribute("departs", list);
			return "admin/depart";

		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Xóa Thất Bại" + id);
			Session session1 = factory.getCurrentSession();
			String hql = "FROM Depart";
			Query query = session.createQuery(hql);
			List<Depart> list = query.list();
			model.addAttribute("departs", list);
			return "admin/depart";
		} finally {
			session.close();
		}
	}
}
