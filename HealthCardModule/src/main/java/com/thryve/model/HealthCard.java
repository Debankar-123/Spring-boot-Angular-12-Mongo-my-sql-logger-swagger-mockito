package com.thryve.model;

import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="HealthCard")
public class HealthCard {
	@Id
	private String cardNo;
	private String cardHolderName;
	private Long mobile;
	private String email;
	private String type;
	private double limit;
	private Date validUpTo;
	private int members;
	private Family[] familyMembers;
	
	public HealthCard() {
		super();
	}
	public HealthCard(String cardNo, String cardHolderName, Long mobile, String email, String type, double limit,
			Date validUpTo, int members, Family[] familyMembers) {
		super();
		this.cardNo = cardNo;
		this.cardHolderName = cardHolderName;
		this.mobile = mobile;
		this.email = email;
		this.type = type;
		this.limit = limit;
		this.validUpTo = validUpTo;
		this.members = members;
		this.familyMembers = familyMembers;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getLimit() {
		return limit;
	}
	public void setLimit(double limit) {
		this.limit = limit;
	}
	public Date getValidUpTo() {
		return validUpTo;
	}
	public void setValidUpTo(Date validUpTo) {
		this.validUpTo = validUpTo;
	}
	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		this.members = members;
	}
	public Family[] getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(Family[] familyMembers) {
		this.familyMembers = familyMembers;
	}
	@Override
	public String toString() {
		return "HealthCard [cardNo=" + cardNo + ", cardHolderName=" + cardHolderName + ", mobile=" + mobile + ", email="
				+ email + ", type=" + type + ", limit=" + limit + ", validUpTo=" + validUpTo + ", members=" + members
				+ ", familyMembers=" + Arrays.toString(familyMembers) + "]";
	}
	


		
}
