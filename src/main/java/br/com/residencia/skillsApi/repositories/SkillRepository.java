package br.com.residencia.skillsApi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.skillsApi.models.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer>{

	Optional<Skill> findByName(String name);
}
