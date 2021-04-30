package com.vobidu.orangetalents.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vobidu.orangetalents.dto.UserDTO;
import com.vobidu.orangetalents.entities.User;
import com.vobidu.orangetalents.repositories.UserRepository;
import com.vobidu.orangetalents.resources.exceptions.FieldMessage;


public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserDTO> {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public void initialize(UserInsertValid ann) {
	}

	@Override
	public boolean isValid(UserDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		User userEmail = repository.findByEmail(dto.getEmail());
		User userCpf = repository.findByCpf(dto.getCpf());
		
		// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
		if (userEmail != null) {
			list.add(new FieldMessage("email", "Email já cadastrado"));
		}
		
		if (userCpf != null) {
			list.add(new FieldMessage("cpf", "CPF já cadastrado"));
		}
		
		//Inserindo a lista de fieldMessage na lista do BeansValidation
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}