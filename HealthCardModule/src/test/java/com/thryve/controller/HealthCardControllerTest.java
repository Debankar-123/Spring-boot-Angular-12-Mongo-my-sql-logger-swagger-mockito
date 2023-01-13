package com.thryve.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.thryve.model.Family;
import com.thryve.model.HealthCard;
import com.thryve.repository.HealthCardRepo;
import com.thryve.service.HealthCardServiceImp;

@RunWith(MockitoJUnitRunner.class)
public class HealthCardControllerTest {

	private MockMvc mockMvc;
	ObjectMapper mapper=new ObjectMapper();
	ObjectWriter objectWriter=mapper.writer();
	
	@Mock
	private HealthCardRepo cardRepo;
	@InjectMocks
	private HealthCardController cardController;
	@Mock
	private HealthCardServiceImp cardServiceImp;
	
	
	Family family1=new Family("Father", "Mr Roul", 55);
	Family family2=new Family("Mother", "Mrs Roul", 45);
	Family[] fArray=new Family[] {family1,family2};
	Date date=new Date(2025, 05, 25);
	
	HealthCard record1=new HealthCard("Deb001", "Debankar", 9898765642L, "debankar@gmail.com", "platinum", 900000,date, 5,fArray);
	HealthCard record2=new HealthCard("Deb002", "Subhankar", 8984457581L, "subhankar@gmail.com", "Gold", 900000,date, 7,fArray);
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(cardController).build();
	}
	@Test
	public void getAllTest() throws Exception {
		List<HealthCard> lst=new ArrayList<>(Arrays.asList(record1,record2));
		//Mockito.when(cardRepo.findAll()).thenReturn(lst);
		Mockito.when(cardServiceImp.getAllHealthCard()).thenReturn(lst);
		mockMvc.perform(MockMvcRequestBuilders
				.get("/api/getAll")
				.contentType(MediaType.APPLICATION_JSON))
		//.andExpect(jsonPath("$[0].CardHolderName", is("Debankar")))
		.andExpect(status().isOk());
		
		
	}
	
	
	
	
	
}
