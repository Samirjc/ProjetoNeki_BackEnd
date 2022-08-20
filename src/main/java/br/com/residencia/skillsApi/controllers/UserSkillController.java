package br.com.residencia.skillsApi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.skillsApi.dtos.UserSkillDTO;
import br.com.residencia.skillsApi.dtos.UserSkillOutDTO;
import br.com.residencia.skillsApi.dtos.UserSkillUpdateDTO;
import br.com.residencia.skillsApi.exceptions.ExistingUserSkillException;
import br.com.residencia.skillsApi.exceptions.NonExistingSkillException;
import br.com.residencia.skillsApi.exceptions.NonExistingUserException;
import br.com.residencia.skillsApi.exceptions.NonExistingUserSkillException;
import br.com.residencia.skillsApi.mappers.UserSkillMapper;
import br.com.residencia.skillsApi.services.UserSkillService;

@RestController
@RequestMapping("/userSkill")
public class UserSkillController {
	
	@Autowired
	UserSkillService userSkillService;
	
	@Autowired
	UserSkillMapper userSkillMapper;
	
	@PostMapping
	public void create(@RequestBody UserSkillDTO dto) throws ExistingUserSkillException, NonExistingUserException, NonExistingSkillException {
		userSkillService.create(userSkillMapper.UserSkillDtoToUserSkill(dto));
	}
	
	@GetMapping("/user/{id}")
	public List<UserSkillOutDTO> findSkillsByUserId(@PathVariable Integer id) {
		List<UserSkillOutDTO> skills = userSkillService.findSkillsByUserId(id).stream().map(item -> userSkillMapper.userSkillToUserSkillOutDto(item)).collect(Collectors.toList());
		return skills;
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Integer id, @RequestBody UserSkillUpdateDTO dto) throws NonExistingUserSkillException {
		userSkillService.update(id, dto.getLevel());
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) throws NonExistingUserSkillException {
		userSkillService.delete(id);
	}
}
