package com.example.demo.controller;

import java.util.List;

//import java.util.logging.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.PatientModule1Application;
import com.example.demo.model.Patient;
import com.example.demo.service.PatientServiceImp;
//import com.mysql.cj.log.LogFactory;

@RestController
@RequestMapping(value="/patient")
@CrossOrigin(origins = "*",maxAge = 3600)
public class PatientController {
	 Logger logger=LoggerFactory.getLogger(PatientModule1Application.class);
	
	@Autowired
	private PatientServiceImp patientServiceImp;
	
	@PostMapping("/add")
	public Patient addPatient(@RequestBody Patient patient) {
		logger.info("add method of controller");
		return patientServiceImp.addPatient(patient);
	}
	@GetMapping("/findAll")
	public List<Patient> getAll(){
		logger.info("getAll method of controller");
		return patientServiceImp.getAll();
	}
	@GetMapping("/findByPatientId/{patientId}")
	public Patient getPatientByPatientId(@PathVariable int patientId) {
		logger.info("findByPatientId method of controller");
		return patientServiceImp.getPatientByPatientId(patientId);
	}
	@GetMapping("/findByPatientCardNo/{patientCardNo}")
	public Patient getByPatientCardNo(@PathVariable String patientCardNo) {
		//System.out.println(patientCardNo);
		logger.info("findByPatientCardNo method of controller");
		return patientServiceImp.getByPatientCardNo(patientCardNo);
	}
	
	@GetMapping("/findByBranchName/{branchName}")
	public List<Patient> getByBranchName(@PathVariable String branchName) {
		//System.out.println(branchName);
		logger.info("getByBranchName method of controller");
		return patientServiceImp.getByBranchName(branchName);
		
	}
	@GetMapping("/findByDistrictName/{patientDistrictName}")
	public List<Patient> getByDistrictName(@PathVariable String patientDistrictName) {
		//System.out.println(patientDistrictName);
		logger.info("getByDistrictName method of controller");
		return patientServiceImp.getByPatientDistrictName(patientDistrictName);
	}
	@GetMapping("/findByStateName/{patientStateName}")
	public List<Patient> getByStateName(@PathVariable String patientStateName) {
		//System.out.println(patientStateName);
		logger.info("getByStateName method of controller");
		return patientServiceImp.getByStateName(patientStateName);
	}
	
	
	@DeleteMapping("/deleteByPatientId/{patientId}")
	public void deletePatientByPatientId(@PathVariable int patientId) {
		logger.warn("deletePatientByPatientId method of controller");
		 patientServiceImp.deletePatientByPatientId(patientId);
	}
	@DeleteMapping("/delete")
	public void deleteAll() {
		logger.warn("deleteAll method of controller");
		patientServiceImp.deleteAll();
	}
	@PutMapping("/update")
	public Patient updatePatient(@RequestBody Patient patient) {
		//System.out.println(patient.getPatientBranchId());
		return patientServiceImp.updatePatient(patient);
	}
	

}
