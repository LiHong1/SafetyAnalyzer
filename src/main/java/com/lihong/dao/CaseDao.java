package com.lihong.dao;

import java.util.List;

import com.lihong.bean.Case;

public interface CaseDao extends BaseDao<Case>{

	/**
	 * 获取相邻案例
	 * @param id
	 * @return
	 */
	List<Case> getCase(Long id);
	
}
