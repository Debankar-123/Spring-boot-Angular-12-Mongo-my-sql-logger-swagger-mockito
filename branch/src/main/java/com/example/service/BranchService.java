package com.example.service;

import java.util.List;

import com.example.model.Branch;

public interface BranchService {
	public Branch addBranch(Branch branch);
	public List<Branch> getAllBranchs();
	public Branch getBranchByBranchCode(int code);
	public List<Branch> getBranchByDist(String dist);
	public List<Branch> getBranchByState(String state);
	public List<Branch> getBranchByCountry(String country);
	public Branch updateBranchByBranchCode(Branch branch);
	public String deleteBranchByBranchCode(int code);
	public Branch getByemail(String email);

}