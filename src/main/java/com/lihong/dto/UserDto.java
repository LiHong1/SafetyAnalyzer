package com.lihong.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDto{

    private String phone;
	private String username;
	private String password1;
	private String password2;
	
	@NotEmpty(message="{user.phone.NotEmpty.message}")
	public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @NotEmpty(message="{user.username.NotEmpty.message}")
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    @NotEmpty(message="{user.password.NotEmpty.message}")
    public String getPassword1() {
        return password1;
    }
    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    @NotEmpty(message="{user.password.NotEmpty.message}")
    public String getPassword2() {
        return password2;
    }
    public void setPassword2(String password2) {
        this.password2 = password2;
    }

	
	
}
