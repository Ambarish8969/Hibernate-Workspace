package com.onetomany1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sim_no;
	private String sim_name;
	private String sim_network_type;
	private int sim_cost;
	private long phno;
	
	public int getSim_no() {
		return sim_no;
	}
	public void setSim_no(int sim_no) {
		this.sim_no = sim_no;
	}
	public String getSim_name() {
		return sim_name;
	}
	public void setSim_name(String sim_name) {
		this.sim_name = sim_name;
	}
	public String getSim_network_type() {
		return sim_network_type;
	}
	public void setSim_network_type(String sim_network_type) {
		this.sim_network_type = sim_network_type;
	}
	public int getSim_cost() {
		return sim_cost;
	}
	public void setSim_cost(int sim_cost) {
		this.sim_cost = sim_cost;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	
}
