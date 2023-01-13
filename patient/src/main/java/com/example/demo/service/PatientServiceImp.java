package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
@Service
public class PatientServiceImp implements PatientService {
	 @Autowired
	    private PatientRepository patientRepository;
	@Override
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
		}

	@Override
	public List<Patient> getAll() {
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatientByPatientId(int patientId) {
		return patientRepository.findById(patientId).get();
	}
	@Override
	public Patient getByPatientCardNo(String patientCardNo) {
		return patientRepository.getByPatientCardNo(patientCardNo);
	}
	@Override
	public List<Patient> getByBranchName(String branchName) {
		return patientRepository.getPatientByBranchName(branchName);
	}

	@Override
	public List<Patient> getByStateName(String patientStateName) {
		return patientRepository.getPatientByStateName(patientStateName);
	}

	@Override
	public List<Patient> getByPatientDistrictName(String patientDistrictName) {
		return patientRepository.getPatientByDistrictName(patientDistrictName);
	}

	@Override
	public void deletePatientByPatientId(int patientId) {
		patientRepository.deleteById(patientId);
	}

	@Override
	public void deleteAll() {
		patientRepository.deleteAll();

	}

	@Override
	public Patient updatePatient(Patient patient) {
		System.out.println(patient.getPatientBranchId());
		System.out.println(patient.getPatientId());
		Patient p=patientRepository.findById(patient.getPatientId()).get();
		p.setPatientTransectionId(patient.getPatientTransectionId());
		p.setPatientId(patient.getPatientId());
		p.setPatientBranchId(patient.getPatientBranchId());
		p.setPatientDistrictName(patient.getPatientDistrictName());
		p.setPatientStateName(patient.getPatientStateName());
		p.setPatientName(patient.getPatientName());
		p.setPatientDateOfUsage(patient.getPatientDateOfUsage());
		 p.setBranchName(patient.getBranchName());
		 return patientRepository.save(p);
	}

}
