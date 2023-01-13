package com.example.demo;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import org.hibernate.mapping.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.demo.model.Patient;
import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.PatientServiceImp;
import com.example.demo.service.PatientServiceImp;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PatientModuleApplicationTests {

	@Test
	void contextLoads() {
	}
	@InjectMocks
	private PatientServiceImp patientServiceImp;
	@Mock
	private PatientRepository patientRepository;
	Date date=new Date(2025, 05, 25);
	

	@Test
	public void addPatientTest() {
		Patient p = new Patient(101,11,"b1","lokesh",21,"a","kurnool","ap",date);
		when(patientRepository.save(p)).thenReturn(p);
		assertEquals(p,patientServiceImp.addPatient(p));

}
	@Test
	public void getAllTest() {
		Patient p = new Patient();
		when(patientRepository.findAll()).thenReturn(Stream.of(new Patient(102,12,"b1","hari",22,"b","kadapa","ap",date),
				new Patient(103,13,"b2","pavan",23,"c","nandyal","ap",date),new Patient(104,14,"b34","arun",24,"d","palli","ap",date))
				.collect(Collectors.toList()));
		assertEquals(3,patientServiceImp.getAll().size());
	}

	@Test
	public void getPatientByCardNoTest() {
		Patient p = new Patient(105,15,"b3","kesav",25,"e","anathapur","anpr",date);
		when(patientRepository.getByPatientCardNo("b3")).thenReturn(p);
		assertEquals(p,patientServiceImp.getByPatientCardNo("b3"));
	}
	@Test
	public void getPatientByPatientId() {
		Patient p = new Patient(106,16,"b3","amr",26,"f","chittor","chtr",date);
		when(patientRepository.findById(p.getPatientId())).thenReturn(Optional.of(p));
		Patient expected = patientServiceImp.getPatientByPatientId(p.getPatientId());
		verify(patientRepository).findById(p.getPatientId());
	
	}
	
	@Test
	public void getByBranchName() {
		Patient branch9=new Patient(107,17,"b4","vinay",27,"g","alagadda","alg",date);
		Patient branch8=new Patient(106,16,"b3","amr",26,"f","chittor","chtr",date);
		List<Patient> list=new ArrayList<>();
		list.add(branch8);
		list.add(branch9);
		when(patientRepository.getPatientByBranchName("alagadda")).thenReturn(list);
		assertEquals(list,patientServiceImp.getByBranchName("alagadda"));
		}
	
	@Test
	public void getByPatientDistrictNameTest() {
		Patient branch9=new Patient(107,17,"b4","vinay",27,"g","alagadda","alg",date);
		Patient branch8=new Patient(106,16,"b3","amr",26,"f","chittor","chtr",date);
		List<Patient> list=new ArrayList<>();
		list.add(branch8);
		list.add(branch9);
		when(patientRepository.getPatientByDistrictName("alagadda")).thenReturn(list);
		assertEquals(list,patientServiceImp.getByPatientDistrictName("alagadda"));
		}
	
	@Test
	public void getByStateName() {
		Patient branch9=new Patient(107,17,"b4","vinay",27,"g","alagadda","alg",date);
		Patient branch8=new Patient(106,16,"b3","amr",26,"f","chittor","chtr",date);
		List<Patient> list=new ArrayList<>();
		list.add(branch8);
		list.add(branch9);
		when(patientRepository.getPatientByStateName("alagadda")).thenReturn(list);
		assertEquals(list,patientServiceImp.getByStateName("alagadda"));
		}
	@Test
	public void deletePatientByPatientId() {
		Patient p =new Patient(107,17,"b7","vinay",27,"g","alagadda","alg",date);
		patientRepository.save(p);
		patientRepository.deleteById(p.getPatientId());;
		Optional optional = patientRepository.findById(p.getPatientTransectionId());
		assertEquals(Optional.empty(),optional);
	}
	@Test
	public void deleteAllTest() {
		patientRepository.deleteAll();;
		
	}
	@Test
	@DirtiesContext
	public void updatePatientTest() {
			Patient p= new Patient(107,178,"b6","vinay",27,"g","alagadda","alg",date);
			
			when(patientRepository.save(p)).thenReturn(p);
			when(patientRepository.findById(107)).thenReturn(Optional.of(p));
			assertEquals(p,patientServiceImp.updatePatient(p));
		}
	
	
}
