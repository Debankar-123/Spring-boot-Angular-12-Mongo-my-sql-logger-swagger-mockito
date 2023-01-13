package com.thryve.service;

import java.util.List;
import java.util.Optional;

import com.thryve.model.HealthCard;

public interface HealthCardService {
	public HealthCard addHealthCard(HealthCard card);
	public List<HealthCard> getAllHealthCard();
	public HealthCard getHealthCardByCardNo(String cardNo);
	public HealthCard updateByCardNo(HealthCard healthCard);
	public void deleteAllHealthCard();
	public void deleteHealthCardByCardNo(String cardNo);
	
}
