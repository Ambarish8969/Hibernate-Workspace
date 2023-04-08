package com.hospital_app.control;

import com.hospital_app.dto.Hospital;
import com.hospital_app.service.HospitalService;

public class TestSaveHospital {
	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		HospitalService hospitalService=new HospitalService();
		hospital.setName("Suguna");
		hospital.setWebsite("www.suguna.com");
		hospitalService.saveHospital(hospital);
	}
}
