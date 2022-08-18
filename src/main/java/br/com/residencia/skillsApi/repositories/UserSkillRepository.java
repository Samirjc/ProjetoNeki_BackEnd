package br.com.residencia.skillsApi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.residencia.skillsApi.models.Skill;
import br.com.residencia.skillsApi.models.User;
import br.com.residencia.skillsApi.models.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Integer>{

	@Query("SELECT us FROM UserSkill us WHERE us.user = ?1 AND us.skill = ?2")
	Optional<UserSkill> findByUserSkill(User user, Skill skill);
	
	@Query("SELECT s FROM Skill s, UserSkill us WHERE us.user.id = ?1 AND us.skill = s")
	List<Skill> findSkillsByUserId(Integer userId);
}
