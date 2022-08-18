package br.com.residencia.skillsApi.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.skillsApi.exceptions.ExistingUserSkillException;
import br.com.residencia.skillsApi.exceptions.NonExistingUserSkillException;
import br.com.residencia.skillsApi.models.Skill;
import br.com.residencia.skillsApi.models.UserSkill;
import br.com.residencia.skillsApi.repositories.UserSkillRepository;

@Service
public class UserSkillService {
	
	@Autowired
	UserSkillRepository userSkillRepository;
	

	public void create(UserSkill userSkill) throws ExistingUserSkillException {
		Optional<UserSkill> optional = userSkillRepository.findByUserSkill(userSkill.getUser(), userSkill.getSkill());

		if (optional.isPresent()) {
			throw new ExistingUserSkillException();
		}

		userSkill.setCreatedAt(LocalDate.now());
		userSkillRepository.save(userSkill);
	}
	
	public List<Skill> findSkillsByUserId(Integer userId) {
		return userSkillRepository.findSkillsByUserId(userId);
	}
	
	public void update(Integer id, Integer level) throws NonExistingUserSkillException {
		Optional<UserSkill> optional = userSkillRepository.findById(id);
		
		if (optional.isEmpty()) {
			throw new NonExistingUserSkillException();
		}
		
		UserSkill userSkill = optional.get();
		userSkill.setKnowledgeLevel(level);
		userSkill.setUpdatedAt(LocalDate.now());
		
		userSkillRepository.save(userSkill);
	}
	
	public void delete(Integer id) throws NonExistingUserSkillException {
		Optional<UserSkill> optional = userSkillRepository.findById(id);
		
		if (optional.isEmpty()) {
			throw new NonExistingUserSkillException();
		}
		
		userSkillRepository.deleteById(id);
	}
}
