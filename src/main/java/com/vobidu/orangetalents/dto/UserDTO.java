package com.vobidu.orangetalents.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.vobidu.orangetalents.entities.User;
import com.vobidu.orangetalents.services.validation.UserInsertValid;

@UserInsertValid
public class UserDTO {
	
	private Long id;
	@NotBlank(message = "O campo nome é obrigatório")
	private String name;
	@Email(message = "Informe um email válido")
	private String email;
	@Pattern(message = "CPF invalido", regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
	private String cpf;
	@Past(message = "Data de nascimento Inválida")
	private LocalDate birthDate;		
	

	public UserDTO() {
		
	}

	public UserDTO(Long id, String name, String email, String cpf, LocalDate birthDate) {
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}		
}
