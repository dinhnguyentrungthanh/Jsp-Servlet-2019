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
import com.poly.bean.Staff;

@Controller
@Transactional
@RequestMapping("/admin/")
public class StaffController {
	@Autowired
	SessionFactory factory;
public String list() {
	return "admin/staff";
}
@RequestMapping("staff")
public String index(ModelMap model) {
	Session session = factory.getCurrentSession();
	String hql = "From Staff";
	Query query = session.createQuery(hql);
	List<Staff> list = query.list();
	model.addAttribute("staffs", list);
	return "admin/staff";
}

@RequestMapping(value = "insert-staff", method = RequestMethod.GET)
public String insert(ModelMap model) {
	model.addAttribute("staff", new Staff());
	return "admin/insert-staff";
}

@RequestMapping(value = "insert-staff", method = RequestMethod.POST)
public String insert(ModelMap model, @Validated @ModelAttribute("staff") Staff staff, BindingResult errors) {
	Session session = factory.openSession();
	Transaction t = session.beginTransaction();
	if(staff.getId().trim().length() == 0) {
		errors.rejectValue("id","staff","Vui Lòng không để trống");
	}
	if(staff.getName().trim().length() == 0) {
		errors.rejectValue("name", "staff", "Vui lòng không đê trống");
	}
	if(staff.getGender() == null ) {
		errors.rejectValue("gender", "staff", "Vui lòng chọn giới tính");
	}
	if(staff.getBirtday() == null) {
		errors.rejectValue("birtday", "staff","Vui lòng nhập ngày tháng năm sinh");
	}
	if(staff.getPhone().trim().length() == 0) {
		errors.rejectValue("phone", "staff", "Vui lòng không để trống ");
	}
	try {
		session.save(staff);
		t.commit();
		model.addAttribute("message1", "Thêm mới thành công " + staff.getId());
		
	} catch (Exception e) {
		t.rollback();
		model.addAttribute("message2", "Thêm mới thất bại !"+ staff.getId());
	} finally {
		session.close();
	}
	return "admin/insert-staff";
}
@ModelAttribute("departs")
public List<Depart> getDeparts() {
	Session session = factory.getCurrentSession();
	String hql = "FROM Depart";
	Query query = session.createQuery(hql);
	List<Depart> list = query.list();
	return list;
}

@RequestMapping("delete-staff")
public String insert(ModelMap model, @RequestParam String id) {
	Session session = factory.openSession();
	Transaction t = session.beginTransaction();
	try {
		Staff staff = (Staff) session.get(Staff.class, id);
		session.delete(staff);
		t.commit();
		model.addAttribute("message1", "Xóa Thành Công " + id);
		Session session2 = factory.getCurrentSession();
		String hql = "From Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		model.addAttribute("staffs", list);
		return "admin/staff";

	} catch (Exception e) {
		t.rollback();
		model.addAttribute("message", "Xóa Thất Bại" + id);
		Session session2 = factory.getCurrentSession();
		String hql = "From Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		model.addAttribute("staffs", list);
		return "admin/staff";
	} finally {
		session.close();
	}
}


@RequestMapping("update-staff")
public String update(ModelMap model, @RequestParam String id) {
	try {
		Session session2 = factory.getCurrentSession();
		Staff staff = (Staff) session2.get(Staff.class, id);

		model.addAttribute("staffss", staff);
	} catch (Exception e) {
		e.printStackTrace();
	}

	return "admin/update-staff";
}

@RequestMapping(value = "update-staff", method = RequestMethod.POST)
public String update(ModelMap model, @ModelAttribute("staffss") Staff staff) {
	Session session = factory.openSession();
	Transaction t = session.beginTransaction();
	try {
		session.update(staff);
		t.commit();
		model.addAttribute("message1", "Sửa mới thành công " + staff.getId());
		Session session1 = factory.getCurrentSession();
		String hql = "From Staff";
		Query query = session.createQuery(hql);
		List<Staff> list = query.list();
		model.addAttribute("staffs", list);
		return "admin/staff";
		
	} catch (Exception e) {
		t.rollback();
		model.addAttribute("message2", "Sửa mới thất bại !"+ staff.getId());
	} finally {
		session.close();
	}
	return "admin/insert-depart";
}
}
