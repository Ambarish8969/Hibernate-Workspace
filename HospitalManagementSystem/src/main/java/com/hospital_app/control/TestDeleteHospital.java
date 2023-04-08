package com.hospital_app.control;

import com.hospital_app.dto.Hospital;
import com.hospital_app.service.HospitalService;

public class TestDeleteHospital {
	public static void main(String[] args) {
		Hospital hospital = new Hospital();
		HospitalService hospitalService=new HospitalService();
		hospitalService.deleteHospitalId(1);
	}
}
