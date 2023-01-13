package com.thryve;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.thryve.model.Family;
import com.thryve.model.HealthCard;
import com.thryve.repository.HealthCardRepo;
import com.thryve.service.HealthCardServiceImp;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class HealthCardModuleApplicationTests {

	@Mock
	private HealthCardRepo cardRepo;
	@InjectMocks
	private HealthCardServiceImp cardServiceImp;
	
	Family family1=new Family("Father", "Mr Roul", 55);
	Family family2=new Family("Mother", "Mrs Roul", 45);
	Family[] fArray=new Family[] {family1,family2};
	Date date=new Date(2025, 05, 25);
	
	HealthCard record1=new HealthCard("Deb001", "Debankar", 9898765642L, "debankar@gmail.com", "platinum", 900000,date, 5,fArray);
	HealthCard record2=new HealthCard("Deb002", "Subhankar", 8984457581L, "subhankar@gmail.com", "Gold", 900000,date, 7,fArray);
	
	
	@Test
	public void addHealthCardTest() {
		Mockito.when(cardRepo.save(record1)).thenReturn(record1);
		assertEquals(record1,cardServiceImp.addHealthCard(record1));
	}
	@Test
	public void getAllHealthCardTest() {
		List<HealthCard> lst=new ArrayList<>();
		lst.add(record1);
		lst.add(record2);
		Mockito.when(cardRepo.findAll()).thenReturn(lst);
		assertEquals(2, cardServiceImp.getAllHealthCard().size());
	}
	@Test
	public void getHealthcardByidTest() {
		Mockito.when(cardRepo.getHealthCardByCardNo("Deb001")).thenReturn(record1);
		assertEquals(record1, cardServiceImp.getHealthCardByCardNo("Deb001"));
	}
	@Test
	public void updateHealthCardTest() {
		Mockito.when(cardRepo.save(record1)).thenReturn(record1);
		Mockito.when(cardRepo.getHealthCardByCardNo("Deb001")).thenReturn(record1);
		assertEquals(record1,cardServiceImp.updateByCardNo(record1));
	}
	@Test
	public void deleteAllHealthCardTest() {
		cardRepo.save(record1);
		cardRepo.save(record2);
		cardServiceImp.deleteAllHealthCard();
		List<HealthCard> list=cardServiceImp.getAllHealthCard();
		assertEquals(0, list.size());
		
		}
	@Test
	public void deleteHealthCardByCardNo() {
		HealthCard record3=new HealthCard("Deb003", "Subhankar", 8984457581L, "subhankar@gmail.com", "Gold", 900000,date, 7,fArray);
		cardServiceImp.deleteHealthCardByCardNo(record3.getCardNo());
		verify(cardRepo,times(1)).deleteById(record3.getCardNo());
		
	}
	

}
