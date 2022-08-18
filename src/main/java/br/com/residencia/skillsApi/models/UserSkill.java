package br.com.residencia.skillsApi.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserSkill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_skill_seq")
	private Integer id;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Skill skill;
	
	@Column
	private LocalDateTime createdAt;
	
	@Column
	private LocalDateTime updatedAt;
	
	
	public UserSkill() {
		super();
	}

	public UserSkill(Integer id, User user, Skill skill, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.user = user;
		this.skill = skill;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}
