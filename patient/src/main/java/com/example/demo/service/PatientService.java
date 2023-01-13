package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Patient;

public interface PatientService {
	public Patient addPatient(Patient patient);
	public List<Patient> getAll();
	public Patient getPatientByPatientId(int patientId);
	public Patient getByPatientCardNo(String patientCardNo);
	public List<Patient> getByBranchName(String branchName);
	public List<Patient> getByStateName(String patientStateName);
	public List<Patient> getByPatientDistrictName(String patientDistrictName);
	public void deletePatientByPatientId(int patientId);
	public void deleteAll();
	public Patient updatePatient(Patient patient);

}
