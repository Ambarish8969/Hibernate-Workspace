package com.hospital_app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Observation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oId;
	private String doctor_name;
	private String reason_observtion;
	@ManyToOne
	@JoinColumn
	private Encounter encounters;

	public int getOid() {
		return oId;
	}

	public void setOid(int oid) {
		oId = oid;
	}

	public String getDoctorName() {
		return doctor_name;
	}

	public void setDoctorName(String dname) {
		this.doctor_name = dname;
	}

	public String getReason_observtion() {
		return reason_observtion;
	}

	public void setReason_observtion(String robservtion) {
		this.reason_observtion = robservtion;
	}

	public Encounter getEncounters() {
		return encounters;
	}

	public void setEncounters(Encounter encounter) {
		this.encounters = encounter;
	}

}
