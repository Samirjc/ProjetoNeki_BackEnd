package br.com.residencia.skillsApi.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.residencia.skillsApi.dtos.UserSkillDTO;
import br.com.residencia.skillsApi.dtos.UserSkillOutDTO;
import br.com.residencia.skillsApi.exceptions.NonExistingSkillException;
import br.com.residencia.skillsApi.exceptions.NonExistingUserException;
import br.com.residencia.skillsApi.models.UserSkill;
import br.com.residencia.skillsApi.services.SkillService;
import br.com.residencia.skillsApi.services.UserService;

@Component
public class UserSkillMapper {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SkillService skillService;
	
	
	public UserSkill UserSkillDtoToUserSkill(UserSkillDTO dto) throws NonExistingUserException, NonExistingSkillException {
		UserSkill userSkill = new UserSkill();
		
		userSkill.setUser(userService.findById(dto.getUserId()));
		userSkill.setSkill(skillService.findById(dto.getSkillId()));
		userSkill.setKnowledgeLevel(dto.getLevel());
		
		return userSkill;
	}
	
	public UserSkillOutDTO userSkillToUserSkillOutDto(UserSkill userSkill) {
		UserSkillOutDTO dto = new UserSkillOutDTO();
		
		dto.setId(userSkill.getId());
		dto.setKnowledgeLevel(userSkill.getKnowledgeLevel());
		dto.setSkill(userSkill.getSkill());
		
		return dto;
	}
}
