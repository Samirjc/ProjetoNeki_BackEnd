package br.com.residencia.skillsApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.residencia.skillsApi.dtos.SkillDTO;
import br.com.residencia.skillsApi.exceptions.ExistingSkillException;
import br.com.residencia.skillsApi.mappers.SkillMapper;
import br.com.residencia.skillsApi.models.Skill;
import br.com.residencia.skillsApi.services.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	SkillMapper skillMapper;
	
	
	@PostMapping
	public void create(@RequestBody SkillDTO dto) throws ExistingSkillException {
		skillService.create(skillMapper.SkillDtoToSkill(dto));
	}
	
	@GetMapping
	public List<Skill> findAll( ){
		return skillService.findAll();
	}
}
