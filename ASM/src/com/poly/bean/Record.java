package com.poly.bean;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Records")
public class Record {
@Id
private String Id;
private Boolean Type;
@ManyToOne
@JoinColumn(name="Stafflid")
private Staff staff;
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public Boolean getType() {
	return Type;
}
public void setType(Boolean type) {
	Type = type;
}
public Staff getStaff() {
	return staff;
}
public void setStaff(Staff staff) {
	this.staff = staff;
}
public Record() {
	super();
	// TODO Auto-generated constructor stub
}
public Record(String id, Boolean type, Staff staff) {
	super();
	Id = id;
	Type = type;
	this.staff = staff;
}

}
