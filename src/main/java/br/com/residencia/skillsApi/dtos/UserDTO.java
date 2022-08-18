package br.com.residencia.skillsApi.dtos;

import javax.validation.constraints.NotNull;

public class UserDTO {
	
	@NotNull
	private String login;
	
	@NotNull
	private String password;
	
	
	public UserDTO() {
		super();
	}

	public UserDTO(@NotNull String login, @NotNull String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
