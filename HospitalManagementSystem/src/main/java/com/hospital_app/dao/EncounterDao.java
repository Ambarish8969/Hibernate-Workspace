package com.hospital_app.dao;

import java.util.List;

import com.hospital_app.dto.Encounter;

public interface EncounterDao {
	public Encounter saveEncounter(int bid, Encounter encounter);
	public List<Encounter> getAllEncounter();
}
