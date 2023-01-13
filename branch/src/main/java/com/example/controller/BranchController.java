package com.example.controller;


import java.util.List;

import org.slf4j.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BranchApplication;
import com.example.model.Branch;
import com.example.service.BranchServiceImp;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/branch")
public class BranchController {

	//private static Logger logger=LogManager.getLogger(BranchApplication.class); 
	 Logger logger=LoggerFactory.getLogger(BranchController.class); 
	
	@Autowired
	public BranchServiceImp branchServiceImp;
	
	@PostMapping("/add")
	public Branch addBranch(@RequestBody Branch branch) {
		logger.info("Add method in Controller");
		return branchServiceImp.addBranch(branch);
	}
	
	@GetMapping("/findAll")
	public List<Branch> getAllBranchs(){
		logger.info("Get All method in Controller");
		return branchServiceImp.getAllBranchs();
	}
	
	@GetMapping("/findById/{code}")
	public Branch getBranchByBranchCode(@PathVariable int code) {
		logger.info("Get By BranchCode  method in Controller");
		return branchServiceImp.getBranchByBranchCode(code);
	}
	
	//add the methods of find by state , dist, country

	@GetMapping("/getByDist/{dist}")
	public List<Branch> getBranchByDist(@PathVariable String dist) {
		logger.info("Get by District method in Controller");
		return branchServiceImp.getBranchByDist(dist);
	}
	

	@GetMapping("/getByState/{state}")
	public List<Branch> getBranchByState(@PathVariable String state) {
		logger.info("Get by State method in Controller");
		return branchServiceImp.getBranchByState(state);
	}
	
	
	@GetMapping("/getByCountry/{country}")
	public List<Branch> getBranchByCountry(@PathVariable String country) {
		logger.info("Get by Country method in Controller");
		return branchServiceImp.getBranchByCountry(country);
	}
	
	
	@PutMapping("/update/{code}")
	public Branch updateBranch(@RequestBody Branch branch) {
		logger.info(" Update by BranchCodemethod in Controller");
		return branchServiceImp.updateBranchByBranchCode(branch);
	}
	

	@DeleteMapping("/deleteById/{code}")
	public String deleteBranch(@PathVariable int code) {
		//System.out.println(branchServiceImp.getBranchByBranchCode(code));
		logger.info("Delete By BranchCode method in Controller");
		branchServiceImp.deleteBranchByBranchCode(code);
		return "Branch Deleted of Branch Code :"+code;//+  branchServiceImp.getBranchByBranchCode(code);
	}
	@GetMapping("/getByemail/{email}")
	public Branch getBranchByEmail(@PathVariable String email) {
		//logger.info("Get by Country method in Controller");
		return branchServiceImp.getByemail(email);
	}
	
}
