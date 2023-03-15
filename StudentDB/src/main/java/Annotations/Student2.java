package Annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // It will generate the ID automatically.
	private int id;
	// length is used only for Strings
	@Column(name="std_name",nullable = false,length=5)  // It will set the column name as "std_name" ,it can't be null and length should be only 5.
	private String name;
	private int age;
	@Column(unique = true) // phno should be unique number.
	private long phno;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}

}
