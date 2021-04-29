package com.vobidu.orangetalents.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vobidu.orangetalents.dto.AdressDTO;
import com.vobidu.orangetalents.services.AdressService;

@RestController
@RequestMapping(value = "/andress")
public class AdressResource {
	
	@Autowired
	private AdressService service;
	
	@PostMapping
	public ResponseEntity<AdressDTO> insert(@RequestBody AdressDTO dto) {
		dto = service.insert(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
}
