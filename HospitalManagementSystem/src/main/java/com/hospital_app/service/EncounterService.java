package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.impl.BranchDaoImpl;
import com.hospital_app.dao.impl.EncounterDaoImpl;
import com.hospital_app.dto.Branch;
import com.hospital_app.dto.Encounter;

public class EncounterService {

	public void saveEncounter(int bid, Encounter encounter) {
		EncounterDaoImpl daoimp = new EncounterDaoImpl();
		Encounter encounter1 = daoimp.saveEncounter(bid, encounter);
		if (encounter1 != null) {
			System.out.println("Data Saved.");
		} else {
			System.out.println("Data not Saved.");
		}
	}

	public Encounter getEncounter(int eid) {
		EncounterDaoImpl daoimp = new EncounterDaoImpl();
		Encounter encounter1 = daoimp.getEncounter(eid);
		if (encounter1 != null) {
			return encounter1;
		} else {
			return null;
		}
	}

	public void deleteEncounter(int eid) {
		EncounterDaoImpl daoimp = new EncounterDaoImpl();
		boolean flag = daoimp.deleteEncounter(eid);

		if (flag) {
			System.out.println("Data Deleted.");
		} else {
			System.out.println("Data not Found.");
		}
	}

	public Encounter updateEncounter(int eid, Encounter encounter) {
		EncounterDaoImpl daoimp = new EncounterDaoImpl();
		Encounter encounter1 = daoimp.updateEncounter(eid, encounter);
		if (encounter1 != null) {
			return encounter1;
		} else {
			return null;
		}
	}

	public void getAllEncounter() {
		EncounterDaoImpl daoimp = new EncounterDaoImpl();
		List<Encounter> encounters = daoimp.getAllEncounter();
		for (Encounter encounter : encounters) {
			System.out.println(encounter);
		}
	}
}
