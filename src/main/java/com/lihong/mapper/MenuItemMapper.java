package com.lihong.mapper;

import java.util.List;

import com.lihong.bean.MenuItem;

public interface MenuItemMapper {
	
	public MenuItem getById(Long id);
	
	public void add(MenuItem MenuItem);
	
	public List <MenuItem> getAll();
	
	public void delete();
	
	public void delete(Long id);
}
