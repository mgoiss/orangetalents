package com.vobidu.orangetalents.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.vobidu.orangetalents.entities.User;

public class UserDTO {
	
	private Long id;
	private String name;
	private String email;
	private String cpf;
	private Date birthDate;	
	
	private List<AdressDTO> adress = new ArrayList<>();
	

	public UserDTO() {
		
	}

	public UserDTO(Long id, String name, String email, String cpf, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}

	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.cpf = user.getCpf();
		this.birthDate = user.getBirthDate();	
		
		user.getAdress().forEach(entity -> this.adress.add(new AdressDTO(entity)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<AdressDTO> getAdress() {
		return adress;
	}		
}
