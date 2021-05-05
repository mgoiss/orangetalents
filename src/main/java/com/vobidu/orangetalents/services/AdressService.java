package com.vobidu.orangetalents.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vobidu.orangetalents.dto.AdressInsertDTO;
import com.vobidu.orangetalents.entities.Adress;
import com.vobidu.orangetalents.entities.User;
import com.vobidu.orangetalents.repositories.AdressRepository;
import com.vobidu.orangetalents.repositories.UserRepository;
import com.vobidu.orangetalents.services.exceptions.EntityNotFoundException;

@Service
public class AdressService {
	@Autowired
	private AdressRepository repository;

	@Autowired
	private UserRepository UserRepository;

	@Transactional
	public AdressInsertDTO insert(AdressInsertDTO dto) {
		Adress entity = new Adress();
		
		entity.setStreet(dto.getStreet());
		entity.setState(dto.getState());
		entity.setCity(dto.getCity());
		entity.setNumber(dto.getNumber());
		entity.setComplement(dto.getComplement());
		entity.setDistrict(dto.getDistrict());
		entity.setPostalCode(dto.getPostalCode());		
		Optional<User> obj = UserRepository.findById(dto.getUser().getId());
		User user = obj.orElseThrow(
				() -> new EntityNotFoundException("Usuário não encontrado"));
		entity.setUser(user);		
		entity = repository.save(entity);				
		return new AdressInsertDTO(entity, entity.getUser());
	}

}
