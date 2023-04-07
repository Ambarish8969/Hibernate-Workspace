package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.impl.ObservationDaoImpl;
import com.hospital_app.dto.Observation;

public class ObservaitonService {

	public void saveObervation(int eid, Observation observation) {
		ObservationDaoImpl daoimp = new ObservationDaoImpl();
		Observation observation1 = daoimp.saveObservation(eid, observation);
		if (observation1 != null) {
			System.out.println("Data Saved.");
		} else {
			System.out.println("Data not Saved.");
		}
	}

	public Observation getObservationId(int oid) {
		ObservationDaoImpl daoimp = new ObservationDaoImpl();
		Observation observation1 = daoimp.getObservationId(oid);
		if (observation1 != null) {
			return observation1;
		} else {
			return null;
		}
	}

	public void deleteObservationId(int oid) {
		ObservationDaoImpl daoimp = new ObservationDaoImpl();
		boolean flag = daoimp.deleteObservationId(oid);

		if (flag) {
			System.out.println("Data Deleted.");
		} else {
			System.out.println("Data not Found.");
		}
	}

	public Observation updateObservationId(int oid, Observation observation) {
		ObservationDaoImpl daoimp = new ObservationDaoImpl();
		Observation observation1 = daoimp.updateObservationId(oid, observation);
		if (observation1 != null) {
			return observation1;
		} else {
			return null;
		}
	}

	public void getAllObservation() {
		ObservationDaoImpl daoimp = new ObservationDaoImpl();
		List<Observation> observations = daoimp.getAllObservation();
		for (Observation observation : observations) {
			System.out.println(observation);
		}
	}

	public void getObservationByDoctorName(String name) {
		ObservationDaoImpl daoimp = new ObservationDaoImpl();
		List<Observation> observations = daoimp.getObservationByDoctorName(name);
		for (Observation observation : observations) {
			System.out.println(observation);
		}
	}
}
