package br.com.residencia.skillsApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.skillsApi.dtos.UserDTO;
import br.com.residencia.skillsApi.exceptions.ExistingUserException;
import br.com.residencia.skillsApi.mappers.UserMapper;
import br.com.residencia.skillsApi.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	
	@PostMapping
	public void create(@RequestBody UserDTO dto) throws ExistingUserException {
		userService.create(userMapper.UserDtoToUser(dto));
	}
}
