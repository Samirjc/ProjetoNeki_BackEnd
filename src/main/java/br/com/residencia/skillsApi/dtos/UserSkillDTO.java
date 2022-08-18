package br.com.residencia.skillsApi.dtos;

import javax.validation.constraints.NotNull;

public class UserSkillDTO {
	
	@NotNull
	private Integer userId;
	
	@NotNull
	private Integer SkillId;
	
	@NotNull
	private Integer level;
	
	
	public UserSkillDTO() {
		super();
	}

	public UserSkillDTO(@NotNull Integer userId, @NotNull Integer skillId, @NotNull Integer level) {
		super();
		this.userId = userId;
		SkillId = skillId;
		this.level = level;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSkillId() {
		return SkillId;
	}

	public void setSkillId(Integer skillId) {
		SkillId = skillId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}
