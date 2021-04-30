package com.vobidu.orangetalents.dto;

import com.vobidu.orangetalents.entities.Adress;

public class AdressInsertDTO extends AdressDTO  {
	
	private UserDTO user;
	
	public AdressInsertDTO() {
		
	}
	
	public AdressInsertDTO(Adress andress) {
		super(andress);
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}	
}
