package com.vobidu.orangetalents.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vobidu.orangetalents.dto.UserDTO;
import com.vobidu.orangetalents.dto.UserListDTO;
import com.vobidu.orangetalents.entities.User;
import com.vobidu.orangetalents.repositories.UserRepository;
import com.vobidu.orangetalents.services.exceptions.EntityNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	@Transactional
	public UserListDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
		
		return new UserListDTO(entity);
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
