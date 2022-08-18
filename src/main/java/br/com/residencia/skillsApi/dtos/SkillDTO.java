package br.com.residencia.skillsApi.dtos;

import javax.validation.constraints.NotNull;

public class SkillDTO {
	
	@NotNull
	private String name;
	
	private String version;
	
	@NotNull
	private String description;
	
	private String imageUrl;
	
	
	public SkillDTO() {
		super();
	}

	public SkillDTO(@NotNull String name, String version, @NotNull String description, String imageUrl) {
		super();
		this.name = name;
		this.version = version;
		this.description = description;
		this.imageUrl = imageUrl;
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
}
