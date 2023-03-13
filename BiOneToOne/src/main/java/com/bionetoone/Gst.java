package com.bionetoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Gst {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int gst_no;
	private String gst_state;
	private String gst_country;
	@OneToOne
	private Company company;
	
	public int getGst_id() {
		return id;
	}
	public void setGst_id(int gst_id) {
		this.id = gst_id;
	}
	public int getGst_no() {
		return gst_no;
	}
	public void setGst_no(int gst_no) {
		this.gst_no = gst_no;
	}
	public String getGst_state() {
		return gst_state;
	}
	public void setGst_state(String gst_state) {
		this.gst_state = gst_state;
	}
	public String getGst_country() {
		return gst_country;
	}
	public void setGst_country(String gst_country) {
		this.gst_country = gst_country;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Gst [gst_id=" + id + ", gst_no=" + gst_no + ", gst_state=" + gst_state + ", gst_country="
				+ gst_country + ", company=" + company + "]";
	}
}
