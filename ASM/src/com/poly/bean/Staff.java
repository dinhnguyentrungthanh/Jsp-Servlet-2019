package com.poly.bean;


import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "Staffs")
public class Staff {
@Id
private String Id;
private String Name;
private Boolean Gender;
@Temporal(TemporalType.DATE)
@DateTimeFormat(iso=ISO.DATE)
private Date Birtday;
private String Phone;
@ManyToOne
@JoinColumn(name="Departld")
private Depart depart;
@OneToMany(mappedBy="staff", fetch=FetchType.EAGER)
private Collection<Record> record;
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public Boolean getGender() {
	return Gender;
}
public void setGender(Boolean gender) {
	Gender = gender;
}
public Date getBirtday() {
	return Birtday;
}
public void setBirtday(Date birtday) {
	Birtday = birtday;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
public Depart getDepart() {
	return depart;
}
public void setDepart(Depart depart) {
	this.depart = depart;
}
public Collection<Record> getRecord() {
	return record;
}
public void setRecord(Collection<Record> record) {
	this.record = record;
}
public Staff() {
	super();
	// TODO Auto-generated constructor stub
}
public Staff(String id, String name, Boolean gender, Date birtday, String phone, Depart depart,
		Collection<Record> record) {
	super();
	Id = id;
	Name = name;
	Gender = gender;
	Birtday = birtday;
	Phone = phone;
	this.depart = depart;
	this.record = record;
}

}
