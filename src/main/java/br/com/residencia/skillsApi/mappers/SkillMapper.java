package br.com.residencia.skillsApi.mappers;

import org.springframework.stereotype.Component;

import br.com.residencia.skillsApi.dtos.SkillDTO;
import br.com.residencia.skillsApi.models.Skill;

@Component
public class SkillMapper {
	
	public Skill SkillDtoToSkill(SkillDTO dto) {
		Skill skill = new Skill();
		
		skill.setName(dto.getName());
		skill.setVersion(dto.getVersion());
		skill.setDescription(dto.getDescription());
		skill.setImageUrl(dto.getImageUrl());
		
		return skill;
	}
}
