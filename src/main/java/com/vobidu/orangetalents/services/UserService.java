package com.vobidu.orangetalents.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vobidu.orangetalents.dto.UserDTO;
import com.vobidu.orangetalents.entities.User;
import com.vobidu.orangetalents.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	@Transactional
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow();
		
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());
		entity.setBirthDate(dto.getBirthDate());
		
		entity = repository.save(entity);
		
		return new UserDTO(entity);
	}
}
