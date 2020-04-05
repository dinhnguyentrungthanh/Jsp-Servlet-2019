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

import com.poly.bean.Record;
import com.poly.bean.Staff;

@Controller
@Transactional
@RequestMapping("/admin/")
public class RecordController {
	@Autowired
	SessionFactory factory;
	
	public String list() {
		return "admin/record";
	}
	@RequestMapping("record")
	public String index(ModelMap model) {
		Session session = factory.getCurrentSession();
		String hql = "From Record";
		Query query = session.createQuery(hql);
		List<Record> list = query.list();
		model.addAttribute("records", list);
		return "admin/record";
	}
	
	@RequestMapping(value = "insert-record", method = RequestMethod.GET)
	public String insert(ModelMap model) {
		model.addAttribute("record", new Record());
		return "admin/insert-record";
	}

	@RequestMapping(value = "insert-record", method = RequestMethod.POST)
	public String insert(ModelMap model, @Validated @ModelAttribute("record") Record record, BindingResult errors) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		if(record.getId().trim().length() == 0) {
			errors.rejectValue("id", "record","Vui lòng không để trống ");
		}
		if(record.getType() == null) {
			errors.rejectValue("type", "record","Vui lòng chọn thành tích");
		}
		try {
			session.save(record);
			t.commit();
			model.addAttribute("message1", "Thêm mới thành công " + record.getId());
			
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message2", "Thêm mới thất bại !"+ record.getId());
		} finally {
			session.close();
		}
		return "admin/insert-record";
	}
	@ModelAttribute("staffs")
	public List<Staff> getDeparts() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		return list;
	}
	
	@RequestMapping("delete-record")
	public String insert(ModelMap model, @RequestParam String id) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Record record = (Record) session.get(Record.class, id);
			session.delete(record);
			t.commit();
			model.addAttribute("message1", "Xóa Thành Công " + id);
			Session session1 = factory.getCurrentSession();
			String hql = "From Record";
			Query query = session.createQuery(hql);
			List<Record> list = query.list();
			model.addAttribute("records", list);
			return "admin/record";
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message", "Xóa Thất Bại" + id);
			Session session1 = factory.getCurrentSession();
			String hql = "From Record";
			Query query = session.createQuery(hql);
			List<Record> list = query.list();
			model.addAttribute("records", list);
			return "admin/record";
		} finally {
			session.close();
		}
		
	}
	
	@RequestMapping("update-record")
	public String update(ModelMap model, @RequestParam String id) {
		try {
			Session session2 = factory.getCurrentSession();
			Record record = (Record) session2.get(Record.class, id);

			model.addAttribute("recordss", record);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "admin/update-record";
	}
	
	@RequestMapping(value = "update-record", method = RequestMethod.POST)
	public String update(ModelMap model, @ModelAttribute("recordss") Record record) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(record);
			t.commit();
			model.addAttribute("message1", "Sửa mới thành công " + record.getId());
			Session session1 = factory.getCurrentSession();
			String hql = "From Record";
			Query query = session.createQuery(hql);
			List<Record> list = query.list();
			model.addAttribute("records", list);
			return "admin/record";
			
		} catch (Exception e) {
			t.rollback();
			model.addAttribute("message2", "Sửa mới thất bại !"+ record.getId());
		} finally {
			session.close();
		}
		return "admin/insert-depart";
	}
}
