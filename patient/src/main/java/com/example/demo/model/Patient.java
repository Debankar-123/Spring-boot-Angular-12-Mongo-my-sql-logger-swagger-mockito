package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity

public class Patient {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int patientId;
	private int patientTransectionId;
	private String patientCardNo;
	private String patientName;
	private int patientBranchId;
	private  String branchName;
	private String patientDistrictName;
	private String patientStateName;
	private Date patientDateOfUsage;
	
	public Patient(int patientId, int patientTransectionId, String patientCardNo, String patientName, int patientBranchId,
			String branchName, String patientDistrictName, String patientStateName, Date patientDateOfUsage) {
		super();
		this.patientId = patientId;
		this.patientTransectionId = patientTransectionId;
		this.patientCardNo = patientCardNo;
		this.patientName = patientName;
		this.patientBranchId = patientBranchId;
		this.branchName = branchName;
		this.patientDistrictName = patientDistrictName;
		this.patientStateName = patientStateName;
		this.patientDateOfUsage = patientDateOfUsage;
	}
	
	
	

	public Patient()
	{
		
	}
	public int getPatientTransectionId() {
		return patientTransectionId;
	}
	public void setPatientTransectionId(int patientTransectionId) {
		this.patientTransectionId = patientTransectionId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientCardNo() {
		return patientCardNo;
	}
	public void setPatientCardNo(String patientCardNo) {
		this.patientCardNo = patientCardNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientBranchId() {
		return patientBranchId;
	}
	public void setPatientBranchId(int patientBranchId) {
		this.patientBranchId = patientBranchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getPatientDistrictName() {
		return patientDistrictName;
	}
	public void setPatientDistrictName(String patientDistrict) {
		this.patientDistrictName = patientDistrict;
	}
	public String getPatientStateName() {
		return patientStateName;
	}
	public void setPatientStateName(String patientStateName) {
		this.patientStateName = patientStateName;
	}
	public Date getPatientDateOfUsage() {
		return patientDateOfUsage;
	}
	public void setPatientDateOfUsage(Date patientDateOfUsage) {
		this.patientDateOfUsage = patientDateOfUsage;
	}
	
}
	
  