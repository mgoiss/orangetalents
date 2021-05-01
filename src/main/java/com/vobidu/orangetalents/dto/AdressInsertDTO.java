package com.vobidu.orangetalents.dto;

import com.vobidu.orangetalents.entities.Adress;
import com.vobidu.orangetalents.entities.User;

public class AdressInsertDTO extends AdressDTO  {
	
	private UserDTO user;
	
	public AdressInsertDTO() {
		
	}
	
	public AdressInsertDTO(Adress adress, User user) {
		super(adress);
		this.user = new UserDTO(user);
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}	
}
