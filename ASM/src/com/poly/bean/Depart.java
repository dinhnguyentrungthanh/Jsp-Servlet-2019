package com.poly.bean;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Departs")
public class Depart {
@Id
private String  Id;
private String Name;
//@OneToMany(mappedBy="depart", fetch=FetchType.EAGER)
//private Collection<Staff> staff;
//public String getId() {
//	return Id;
//}
//public void setId(String id) {
//	Id = id;
//}
//public String getName() {
//	return Name;
//}
//public void setName(String name) {
//	Name = name;
//}
//public Collection<Staff> getStaff() {
//	return staff;
//}
//public void setStaff(Collection<Staff> staff) {
//	this.staff = staff;
//}
//public Depart() {
//	super();
//	// TODO Auto-generated constructor stub
//}
//public Depart(String id, String name, Collection<Staff> staff) {
//	super();
//	Id = id;
//	Name = name;
//	this.staff = staff;
//}
//public Depart(String id, String name) {
//	Id = id;
//	Name = name;
//}
//

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
public Depart() {
	super();
	// TODO Auto-generated constructor stub
}
public Depart(String id, String name) {
	super();
	Id = id;
	Name = name;
}


}
