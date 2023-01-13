package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.model.Branch;
import com.example.repository.BranchRepository;
import com.example.service.BranchServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
class BranchApplicationTests {

//	@Test
//	void contextLoads() {
//	}
	
	@Autowired
	private BranchServiceImp service;
	
	@MockBean
	private BranchRepository repository;
	
	Branch branch1=new Branch(1,81,"abc","sai","abc","ap","India");
	Branch branch2=new Branch(2,8122,"xyz","shankar","xyz","tel","usa");
	
	
	@Test
	public void addBranchTest() {
		Mockito.when(repository.save(branch1)).thenReturn(branch1);
		assertEquals(branch1,service.addBranch(branch1));
	}
	
	@Test
	public void getAllBranchsTest() {
//		when(repository.findAll()).thenReturn(Stream
//				.of(new Branch(1,81,"abc","sai","abc","ap","India"),new Branch(2,8122,"xyz","shankar","xyz","tel","usa")).collect(Collectors.toList()));
//		assertEquals(2,service.getAllBranchs().size());
		List<Branch> br=new ArrayList<>();
		br.add(branch1);
		br.add(branch2);
		Mockito.when(repository.findAll()).thenReturn(br);
		assertEquals(2,service.getAllBranchs().size());
	}
	
	@Test
	public void getBranchByBranchCodeTest() {
		Branch branch3=new Branch(3,81225,"str","shankar","str","tel","usa");
		Mockito.when(repository.findById(3)).thenReturn(Optional.of(branch3));
		assertEquals(branch3,service.getBranchByBranchCode(3));
	}
	
	@Test
	public void getBranchByDistTest() {
		Branch branch9=new Branch(1,81,"abc","sai","ss","ap","India");
		Branch branch8=new Branch(2,8122,"xyz","shankar","ss","tel","usa");
		List<Branch> list=new ArrayList<>();
		list.add(branch8);
		list.add(branch9);
		Mockito.when(repository.getBranchByDist("xyz")).thenReturn(list);
		assertEquals(list,service.getBranchByDist("xyz"));
		//d=(List<Branch>) Stream.of()
	//	Mockito.when(repository.getBranchByDist("xyz")).thenReturn(d.stream().filter(d->d.getDistrict().equalsIgnoreCase("xyz").findFirst()));//Stream.of());//d);
//		d.stream().filter(p->p.getDistrict().equalsIgnoreCase("xyz").findFirst();
	//	assertEquals(d,service.getBranchByDist("xyz"));
		//List<Branch> dist=d.stream().filter(f->f.getDist().equals("xyz")).map(obj->obj.getDist()).collect(Collectors.toList());
		//List<Branch> list=new ArrayList<>();
		//list.add(,)
		
	}
	
	@Test
	public void getBranchByStateTest() {
		Branch branch4=new Branch(4,812209,"abc","sai","ss","ap","India");
		Branch branch5=new Branch(5,812,"xyz","shankar","ss","tel","usa");
		Branch branch6=new Branch(6,812250,"ntr","sham","ntr","tel","usa");
		List<Branch> list=new ArrayList<>();
		list.add(branch4);
		list.add(branch5);
		Mockito.when(repository.getBranchByState("tel")).thenReturn(list);
		assertEquals(list,service.getBranchByState("tel"));
		//Mockito.when(repository.getBranchByState("tel")).thenReturn(branch2);
		//assertEquals(list,service.getBranchByState("tel"));
	}
	
	@Test
	public void getBranchByCountryTest() {
		Branch branch10=new Branch(10,81220,"abc","sai","ss","ap","India");
		Branch branch11=new Branch(11,81211,"xyz","shankar","ss","tel","usa");
		Branch branch12=new Branch(12,812250,"ntr","sham","ntr","tel","India");
		List<Branch> list=new ArrayList<>();
		list.add(branch10);
		list.add(branch11);
		list.add(branch12);
		Mockito.when(repository.getBranchByCountry("India")).thenReturn(list);
		assertEquals(list,service.getBranchByCountry("India"));
		//Mockito.when(repository.getBranchByCountry("India")).thenReturn(branch1);
		//assertEquals(branch1,service.getBranchByCountry("India"));
	}
	
	@Test
	public void updateBranchTest() {
//		Optional<Branch> branch7=Optional.ofNullable(new Branch(7,812250,"ntr","sham","ntr","tel","usa"));
		Branch branch7=new Branch(7,812250,"ntr","sham","ntr","tel","usa");

		Mockito.when(repository.save(branch7)).thenReturn(branch7);
		Mockito.when(repository.findById(7)).thenReturn(Optional.of(branch7));
		assertEquals(branch7,service.updateBranchByBranchCode(branch7));
	}
	
	@Test
	public void deleteBranchTest() {
		service.deleteBranchByBranchCode(branch2.getBranchCode());
		verify(repository,times(1)).deleteById(branch2.getBranchCode());
		//Branch branch6=new Branch(6,812250,"ntr","sham","ntr","tel","usa");
//		Mockito.when(repository.save(branch2)).thenReturn(branch2);
//		Mockito.when(repository.findById(2)).thenReturn(Optional.of(branch2));
//		assertEquals(branch2,service.deleteBranchByBranchCode(2));
	//	assertEquals(branch2,service.deleteBranchByBranchCode(2));    //delete(branch1));
		//assertEquals(,service.getBranchByBranchCode(2).size()); 
	}

}
