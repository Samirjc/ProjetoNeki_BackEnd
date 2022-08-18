package br.com.residencia.skillsApi.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_seq")
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String version;
	
	@Column
	private String description;
	
	@Column
	private String imageUrl;
	
	@OneToMany(mappedBy = "skill")
	private List<UserSkill> userSkill;
	
	
	public Skill() {
		super();
	}


	public Skill(Integer id, String name, String version, String description, String imageUrl,
			List<UserSkill> userSkill) {
		super();
		this.id = id;
		this.name = name;
		this.version = version;
		this.description = description;
		this.imageUrl = imageUrl;
		this.userSkill = userSkill;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public List<UserSkill> getUserSkill() {
		return userSkill;
	}


	public void setUserSkill(List<UserSkill> userSkill) {
		this.userSkill = userSkill;
	}
}
