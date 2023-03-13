package com.employee2;

import java.util.Scanner;

public class MainClas {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		AddEmployee ae = new AddEmployee();
		DeleteEmployee de = new DeleteEmployee();
		GetAllEmployee gae = new GetAllEmployee();
		GetEmployee ge = new GetEmployee();
		UpdateEmployee ue = new UpdateEmployee();
		while (true) {
			System.out.println("----------Welcome to Employee Database----------");
			System.out.println(
					"1:Add Employee\n2:Get Employee\n3:Update Employee\n4:Delete Employee\n5:Get All Employees\n6:Exit");
			System.out.println("Enter your choice : ");
			int choice = ip.nextInt();
			switch (choice) {
			case 1:
				ae.addEmployee();
				break;
			case 2:
				ge.getEmployee();
				break;
			case 3:
				ue.updateEmployee();
				break;
			case 4:
				de.deleteEmployee();
				break;
			case 5:
				gae.getAllEmployees();
				break;
			case 6:
				System.out.println("Thank You");
				System.exit(0);
			default:
				System.out.println("Invalid Choice");
			}

		}

	}
}
