package com.hospital_app.service;

import java.util.List;

import com.hospital_app.dao.impl.BranchDaoImpl;
import com.hospital_app.dto.Branch;

public class BranchService {

	public void saveBranch(int hid, Branch branch) {
		BranchDaoImpl daoimp = new BranchDaoImpl();
		Branch branch1 = daoimp.saveBranch(hid, branch);
		if (branch1 != null) {
			System.out.println("Data Saved.");
		} else {
			System.out.println("Data not Saved.");
		}
	}
 
	public Branch getBranch(int bid) {
		BranchDaoImpl daoimp = new BranchDaoImpl();
		Branch branch1 = daoimp.getBranch(bid);
		if (branch1 != null) {
			return branch1;
		} else {
			return null;
		}
	}

	public void deleteBranch(int bid) {
		BranchDaoImpl daoimp = new BranchDaoImpl();
		boolean flag = daoimp.deleteBranch(bid);

		if (flag) {
			System.out.println("Data Deleted.");
		} else {
			System.out.println("Data not Found.");
		}
	}

	public Branch updateBranch(int bid, Branch branch) {
		BranchDaoImpl daoimp = new BranchDaoImpl();
		Branch branch1 = daoimp.updateBranch(bid, branch);
		if (branch1 != null) {
			return branch1;
		} else {
			return null;
		}
	}

	public void getAllBranches() {
		BranchDaoImpl daoimp = new BranchDaoImpl();
		List<Branch> branchs = daoimp.getAllBranches();
		for(Branch branch:branchs) {
			System.out.println(branch);
		}
	}
}
