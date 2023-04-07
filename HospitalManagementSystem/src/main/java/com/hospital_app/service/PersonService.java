package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.impl.PersonDaoImpl;
import com.hospital_app.dto.Person;

public class PersonService {

	public void savePerson(int personId, Person person) {
		PersonDaoImpl daoimp = new PersonDaoImpl();
		Person person1 = daoimp.savePerson(personId, person);
		if (person1 != null) {
			System.out.println("Data Saved.");
		} else {
			System.out.println("Data not Saved.");
		}
	}

	public Person getPersonId(int personId) {
		PersonDaoImpl daoimp = new PersonDaoImpl();
		Person person1 = daoimp.getPersonId(personId);
		if (person1 != null) {
			return person1;
		} else {
			return null;
		}
	}

	public void deletePersonId(int personId) {
		PersonDaoImpl daoimp = new PersonDaoImpl();
		boolean flag = daoimp.deletePersonId(personId);

		if (flag) {
			System.out.println("Data Deleted.");
		} else {
			System.out.println("Data not Found.");
		}
	}

	public Person updatePersonId(int personId, Person person) {
		PersonDaoImpl daoimp = new PersonDaoImpl();
		Person person1 = daoimp.updatePersonId(personId, person);
		if (person1 != null) {
			return person1;
		} else {
			return null;
		}
	}

	public void getAllPerson() {
		PersonDaoImpl daoimp = new PersonDaoImpl();
		List<Person> persons = daoimp.getAllPerson();
		for (Person person : persons) {
			System.out.println(person);
		}
	}

	public void getPersonByGender(String gender) {
		PersonDaoImpl daoimp = new PersonDaoImpl();
		List<Person> persons = daoimp.getPersonByGender(gender);
		for (Person person : persons) {
			System.out.println(person);
		}
	}

	public void getPersonByAge(int age) {
		PersonDaoImpl daoimp = new PersonDaoImpl();
		List<Person> persons = daoimp.getPersonByAge(age);
		for (Person person : persons) {
			System.out.println(person);
		}
	}

	public void getPersonByPhone(long phone) {
		PersonDaoImpl daoimp = new PersonDaoImpl();
		List<Person> persons = daoimp.getPersonByPhone(phone);
		for (Person person : persons) {
			System.out.println(person);
		}
	}
}
