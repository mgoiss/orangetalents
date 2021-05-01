package com.vobidu.orangetalents.dto;

import java.util.ArrayList;
import java.util.List;

import com.vobidu.orangetalents.entities.User;

public class UserListDTO extends UserDTO{
	private List<AdressDTO> adress = new ArrayList<>();
	
	public UserListDTO(User user) {
		super(user);			
		user.getAdress().forEach(entity -> this.adress.add(new AdressDTO(entity)));
	}
	
	public List<AdressDTO> getAdress() {
		return adress;
	}
}
