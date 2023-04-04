package com.hospital_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String reason;
	private String dateOfJoin;
	private String dateOfDischarge;
	@OneToMany(mappedBy = "encounters")
	private List<Observation> obs;
	@JoinColumn
	@ManyToOne
	private Person person;
	@JoinColumn
	@ManyToOne
	private Branch branch;
	@OneToMany(mappedBy = "encounter")
	private List<Medorder> order;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public String getDateOfDischarge() {
		return dateOfDischarge;
	}

	public void setDateOfDischarge(String dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}

	public List<Observation> getObs() {
		return obs;
	}

	public void setObs(List<Observation> obs) {
		this.obs = obs;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Medorder> getOrder() {
		return order;
	}

	public void setOrder(List<Medorder> order) {
		this.order = order;
	}
}
