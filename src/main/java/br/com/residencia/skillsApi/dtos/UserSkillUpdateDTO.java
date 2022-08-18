package br.com.residencia.skillsApi.dtos;

import javax.validation.constraints.NotNull;

public class UserSkillUpdateDTO {
	
	@NotNull
	private Integer level;
	
	
	public UserSkillUpdateDTO() {
		super();
	}

	public UserSkillUpdateDTO(@NotNull Integer level) {
		super();
		this.level = level;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}
