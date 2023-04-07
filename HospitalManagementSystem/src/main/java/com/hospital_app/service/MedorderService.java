package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.impl.MedorderDaoImpl;
import com.hospital_app.dto.Medorder;

public class MedorderService {

	public void saveMedorder(int mid, Medorder medorder) {
		MedorderDaoImpl daoimp = new MedorderDaoImpl();
		Medorder medorder1 = daoimp.saveMedorder(mid, medorder);
		if (medorder1 != null) {
			System.out.println("Data Saved.");
		} else {
			System.out.println("Data not Saved.");
		}
	}

	public Medorder getMedorder(int mid) {
		MedorderDaoImpl daoimp = new MedorderDaoImpl();
		Medorder medorder1 = daoimp.getMedorder(mid);
		if (medorder1 != null) {
			return medorder1;
		} else {
			return null;
		}
	}

	public void deleteMedorder(int mid) {
		MedorderDaoImpl daoimp = new MedorderDaoImpl();
		boolean flag = daoimp.deleteMedorder(mid);

		if (flag) {
			System.out.println("Data Deleted.");
		} else {
			System.out.println("Data not Found.");
		}
	}

	public Medorder updateMedorder(int mid, Medorder medorder) {
		MedorderDaoImpl daoimp = new MedorderDaoImpl();
		Medorder medorder1 = daoimp.updateMedorder(mid, medorder);
		if (medorder1 != null) {
			return medorder1;
		} else {
			return null;
		}
	}

	public void getAllMedorder() {
		MedorderDaoImpl daoimp = new MedorderDaoImpl();
		List<Medorder> medorders = daoimp.getAllMedorder();
		for (Medorder medorder : medorders) {
			System.out.println(medorder);
		}
	}

	public void getMedorderByDoctorname(String name) {
		MedorderDaoImpl daoimp = new MedorderDaoImpl();
		List<Medorder> medorders = daoimp.getMedorderByDoctorname(name);
		for (Medorder medorder : medorders) {
			System.out.println(medorder);
		}
	}
}
