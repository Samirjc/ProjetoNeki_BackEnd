package br.com.residencia.skillsApi.dtos;

import br.com.residencia.skillsApi.models.Skill;

public class UserSkillOutDTO {
	private Integer id;
	private Integer knowledgeLevel;
	private Skill skill;
	
	
	public UserSkillOutDTO() {
		super();
	}
	
	public UserSkillOutDTO(Integer id, Integer knowledgeLevel, Skill skill) {
		super();
		this.id = id;
		this.knowledgeLevel = knowledgeLevel;
		this.skill = skill;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getKnowledgeLevel() {
		return knowledgeLevel;
	}
	
	public void setKnowledgeLevel(Integer knowledgeLevel) {
		this.knowledgeLevel = knowledgeLevel;
	}
	
	public Skill getSkill() {
		return skill;
	}
	
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}
