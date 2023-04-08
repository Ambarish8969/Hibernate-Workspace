package com.hospital_app.service;

import com.hospital_app.dao.impl.HospitalDaoImpl;
import com.hospital_app.dto.Hospital;

public class HospitalService {
	public void saveHospital(Hospital hospital) {
		HospitalDaoImpl daoimp = new HospitalDaoImpl();
		Hospital hospital1 = daoimp.saveHospital(hospital);
		if (hospital1 != null) {
			System.out.println("Data Saved.");
		} else {
			System.out.println("Data not Saved.");
		}
	}

	public Hospital getHospitalId(int hid) {
		HospitalDaoImpl daoimp = new HospitalDaoImpl();
		Hospital hospital1 = daoimp.getHospitalId(hid);
		if (hospital1 != null) {
			return hospital1;
		} else {
			return null;
		}
	}

	public void deleteHospitalId(int hid) {
		HospitalDaoImpl daoimp = new HospitalDaoImpl();
		boolean flag = daoimp.deleteHospitalId(hid);

		if (flag) {
			System.out.println("Data Deleted.");
		} else {
			System.out.println("Data not Found.");
		}
	}

	public Hospital updateHospialById(int hid, Hospital hospital) {
		HospitalDaoImpl daoimp = new HospitalDaoImpl();
		Hospital hospital2 = daoimp.updateHospital(hid, hospital);
		if (hospital2 != null) {
			return hospital2;
		} else {
			return null;
		}
	}
}
