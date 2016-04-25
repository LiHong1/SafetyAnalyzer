package com.lihong.bean;

import java.io.ObjectOutputStream.PutField;

import javax.validation.constraints.NotNull;

public class User extends DomainObject{
    
	private String username;
	private String password;
	private String phone;
	private Integer type;
	
	public User() {
        super();
    }


    public User(String phone,String username,String password,Integer type){
	    this.phone = phone;
	    this.username = username;
	    this.password = password;
	    this.type = type;
	}
	
	@NotNull(message="{javax.validation.constraints.NotNull.message}")
	public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NotNull(message="{javax.validation.constraints.NotNull.message}")
    public String getUsername() {
		return username;
	}
    
    
	public void setUsername(String username) {
		this.username = username;
	}
	
    @NotNull(message="{javax.validation.constraints.NotNull.message}")
	public String getPassword() {
	    return password;
	}
	   
	public void setPassword(String password) {
		this.password = password;
	}


    public Integer getType() {
        return type;
    }


    public void setType(Integer type) {
        this.type = type;
    }
	
	
}
