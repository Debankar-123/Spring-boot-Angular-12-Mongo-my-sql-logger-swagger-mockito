package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int branchCode;
	private int hospitalId;
	private String branchName;
	private String email;
	private String dist;
	private String state;
	private String country;
	
	public Branch( int branchCode,int hospitalId, String branchName, String branchManager, String dist,
			String state, String country) {
		super();
		
		this.branchCode = branchCode;
		this.hospitalId = hospitalId;
		this.branchName = branchName;
		this.email = branchManager;
		this.dist = dist;
		this.state = state;
		this.country = country;
	}
	public Branch() {
		super();
	}
	
	
	public int getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(int branchCode) {
		this.branchCode = branchCode;
	}
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String branchManager) {
		this.email = branchManager;
	}
	public String getDist() {
		return dist;
	}
	public void setDist(String dist) {
		this.dist = dist;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Branch [branchCode=" + branchCode + ", hospitalId=" + hospitalId + ", branchName=" + branchName
				+ ", branchManager=" + email + ", dist=" + dist + ", state=" + state + ", country="
				+ country + "]";
	}
	
	
	
}








/*
//com.mysql.cj.jdbc.Driver                  in application properties

//<configuration>
<excludes>
<exclude>
	<groupId>org.projectlombok</groupId>
	<artifactId>lombok</artifactId>
</exclude>
</excludes>
</configuration>
*/