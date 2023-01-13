package com.thryve.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thryve.HealthCardModuleApplication;
import com.thryve.model.HealthCard;
import com.thryve.service.HealthCardServiceImp;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*",maxAge = 3600)
public class HealthCardController {
 
	private static Logger logger=LoggerFactory.getLogger(HealthCardModuleApplication.class);
	@Autowired
	HealthCardServiceImp cardServiceImp;
	@GetMapping("/getAll")
	public List<HealthCard> getAll(){
		List<HealthCard> h=cardServiceImp.getAllHealthCard();
		//System.out.println(h);
		logger.info("getAll is work ");
		return h;
	}
	@GetMapping("/getAll/{cardNo}")
	public HealthCard getByCardNo(@PathVariable String cardNo){
		if(cardNo!=null) {
		 HealthCard hCard= cardServiceImp.getHealthCardByCardNo(cardNo);
		 System.out.println(hCard);
		 if(hCard==null) {
			 logger.error("card not exist"+hCard);
		 }
		 return hCard;
		}else {
			logger.error("cardNo is empty");
			return null;
		}
	}
	@PostMapping("/add")
	public HealthCard addHealthCard(@RequestBody HealthCard card) {
		//System.out.println(card);
		logger.info("In addHealthCard method of controller");
		return cardServiceImp.addHealthCard(card);
		
	}
	@DeleteMapping("/deleteAll")
	public void deleteAllHealthCard() {
		logger.warn("In deleteAllHealthCard method of controller");
		cardServiceImp.deleteAllHealthCard();
	}
	@DeleteMapping("/deleteAll/{cardNo}")
	public void deleteHealthCardByCardNo(@PathVariable String cardNo) {
		logger.warn("In deleteAllHealthCard method of controller delete "+cardNo);
		cardServiceImp.deleteHealthCardByCardNo(cardNo);
	}
	@PutMapping("/update")
	public HealthCard update(@RequestBody HealthCard card) {
		logger.info("In update HealthCard method of controller"); 
		return cardServiceImp.updateByCardNo(card);
	}
	
}
