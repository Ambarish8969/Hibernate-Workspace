package com.bionetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Company {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String company_name;
	private String company_website;
	private String company_location;
	@OneToOne
	private Gst gst;
	
	public int getCompany_id() {
		return id;
	}
	public void setCompany_id(int company_id) {
		this.id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_website() {
		return company_website;
	}
	public void setCompany_website(String company_website) {
		this.company_website = company_website;
	}
	public String getCompany_location() {
		return company_location;
	}
	public void setCompany_location(String company_location) {
		this.company_location = company_location;
	}
	public Gst getGst() {
		return gst;
	}
	public void setGst(Gst gst) {
		this.gst = gst;
	}
	@Override
	public String toString() {
		return "Company [company_id=" + id + ", company_name=" + company_name + ", company_website="
				+ company_website + ", company_location=" + company_location + ", gst=" + gst + "]";
	}
	
}
