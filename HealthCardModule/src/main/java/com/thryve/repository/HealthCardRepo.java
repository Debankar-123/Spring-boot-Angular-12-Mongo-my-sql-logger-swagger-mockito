package com.thryve.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.thryve.model.HealthCard;

@Repository
public interface HealthCardRepo extends MongoRepository<HealthCard, String> {
	
	@Query(value="{cardNo:?0}")
	public HealthCard getHealthCardByCardNo(String cardNo);

}
