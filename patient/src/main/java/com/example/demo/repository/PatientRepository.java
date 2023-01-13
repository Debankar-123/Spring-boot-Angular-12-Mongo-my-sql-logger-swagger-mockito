package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	@Query("select b from Patient b where b.branchName=:bName")
	public List<Patient> getPatientByBranchName(@Param ("bName") String bName);
	
	@Query("select b from Patient b where b.patientStateName=:s")
	public List<Patient> getPatientByStateName(@Param ("s") String s);
	
	@Query("select b from Patient b where b.patientDistrictName=:d")
	public List<Patient> getPatientByDistrictName(@Param("d")String d);
	
	@Query("select b from Patient b where b.patientCardNo=:c")
	public Patient getByPatientCardNo(@Param ("c") String c);
	
	
}
