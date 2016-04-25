package com.lihong.dao;

import java.util.List;

import com.lihong.bean.Case;
import com.lihong.common.bean.PageBean;
import com.lihong.common.dao.BaseDao;
import com.lihong.dto.CasePageBeanDto;

public interface CaseDao extends BaseDao<Case>{

	/**
	 * 获取相邻案例
	 * @param id
	 * @return
	 */
	List<Case> getCase(Long id);
	
	/**
     * 带参数的查询
     * @param currentPage
     * @param pageSize
     * @param t
     * @return
     */
    public PageBean<Case> getPage(int currentPage,int pageSize,CasePageBeanDto casePageBeanDto);
    
  
}
