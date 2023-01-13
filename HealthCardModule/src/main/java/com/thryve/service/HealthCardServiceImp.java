package com.thryve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thryve.model.HealthCard;
import com.thryve.repository.HealthCardRepo;
@Service
public class HealthCardServiceImp implements HealthCardService{

	
	@Autowired
	HealthCardRepo cardRepo;
	@Override
	public HealthCard addHealthCard(HealthCard card) {
		return cardRepo.save(card);
		
	}

	@Override
	public List<HealthCard> getAllHealthCard() {
		return cardRepo.findAll();
	}

	@Override
	public HealthCard getHealthCardByCardNo(String cardNo) {
		
		return cardRepo.getHealthCardByCardNo(cardNo);
	}

	@Override
	public HealthCard updateByCardNo(HealthCard healthCard) {
	//	Optional<HealthCard> hCard=cardRepo.findById(healthCard.getCardNo());
		HealthCard hCard=cardRepo.getHealthCardByCardNo(healthCard.getCardNo());
		System.out.println(hCard);
		hCard.setCardHolderName(healthCard.getCardHolderName());
		hCard.setEmail(healthCard.getEmail());
		hCard.setFamilyMembers(healthCard.getFamilyMembers());
		hCard.setLimit(healthCard.getLimit());
		hCard.setMembers(healthCard.getMembers());
		hCard.setMobile(healthCard.getMobile());
		hCard.setType(healthCard.getType());
		hCard.setValidUpTo(healthCard.getValidUpTo());
		
		return cardRepo.save(hCard);
	}

	@Override
	public void deleteAllHealthCard() {
		cardRepo.deleteAll();
		
	}

	@Override
	public void deleteHealthCardByCardNo(String cardNo) {
		cardRepo.deleteById(cardNo);
		
	}

}
