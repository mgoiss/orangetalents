package com.vobidu.orangetalents.dto;

import com.vobidu.orangetalents.entities.Adress;

public class AdressDTO {
	
	private Long id;
	private String street;
	private String number;
	private String complement;
	private String district;
	private String city;
	private String state;
	private String postalCode;		
	
	public AdressDTO() {
		
	}

	public AdressDTO(Long id, String street, String number, String complement, String district, String city,
			String state, String postalCode) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.district = district;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}

	public AdressDTO(Adress andress) {
		this.id = andress.getId();
		this.street = andress.getStreet();
		this.number = andress.getNumber();
		this.complement = andress.getComplement();
		this.district = andress.getDistrict();
		this.city = andress.getCity();
		this.state = andress.getState();
		this.postalCode = andress.getPostalCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}	
}
