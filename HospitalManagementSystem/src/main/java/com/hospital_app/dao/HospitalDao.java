package com.hospital_app.dao;

import com.hospital_app.dto.Hospital;

public interface HospitalDao {
	public Hospital saveHospital(Hospital hospital);

	public Hospital getHospitalId(int hid);

	public boolean deleteHospitalId(int hid);

	public Hospital updateHospital(int hid, Hospital hospital);
}
