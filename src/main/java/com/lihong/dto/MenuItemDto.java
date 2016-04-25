package com.lihong.dto;

import com.lihong.bean.DomainObject;

/**
 * 菜单类
 * @author lihong2-ext
 *
 */
public class MenuItemDto extends DomainObject{
    //ID
	private Integer id;
	//菜单名称
	private String name;
	//菜单地址
	private String url;
	//菜单类型
	private Integer type;
	//父级菜单
	private Long pId;
	//图标
	private String inco;
	//是否显示
	private Boolean visiable;
	//显示序号
	private Integer order;
	//显示权限
	private String authority;
	
	
	public MenuItemDto() {
		
	}
	
	
	
	public MenuItemDto(Integer id,String name, String url, Long pId, Boolean visiable) {
		super();
		this.name = name;
		this.url = url;
		this.pId = pId;
		this.visiable = visiable;
		this.id = id;
		
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getPId() {
		return pId;
	}
	public void setPId(Long pId) {
		this.pId = pId;
	}
	public String getInco() {
		return inco;
	}
	public void setInco(String inco) {
		this.inco = inco;
	}
	public Boolean getVisiable() {
		return visiable;
	}
	public void setVisiable(Boolean visiable) {
		this.visiable = visiable;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public Integer getOrder() {
		return order;
	}


	public void setOrder(Integer order) {
		this.order = order;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}




	
	
 
}
