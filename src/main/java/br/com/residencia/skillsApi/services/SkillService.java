package br.com.residencia.skillsApi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.skillsApi.exceptions.ExistingSkillException;
import br.com.residencia.skillsApi.exceptions.NonExistingSkillException;
import br.com.residencia.skillsApi.models.Skill;
import br.com.residencia.skillsApi.repositories.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	SkillRepository skillRepository;
	
	
	public void create(Skill skill) throws ExistingSkillException {
		Optional<Skill> optional = skillRepository.findByName(skill.getName());
		
		if(optional.isPresent()) {
			throw new ExistingSkillException();
		}
		
		skillRepository.save(skill);
	}
	
	public Skill findById(Integer id) throws NonExistingSkillException {
		Optional<Skill> optional = skillRepository.findById(id);
		
		if(optional.isEmpty()) {
			throw new NonExistingSkillException();
		}
		
		return optional.get();
	}
}
