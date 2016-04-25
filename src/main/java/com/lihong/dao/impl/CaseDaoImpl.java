package com.lihong.dao.impl;

import java.util.List;

import com.lihong.bean.Case;
import com.lihong.common.bean.EPageBean;
import com.lihong.common.bean.PageBean;
import com.lihong.common.daoImpl.BaseDaoImpl;
import com.lihong.dao.CaseDao;
import com.lihong.dto.CasePageBeanDto;

public class CaseDaoImpl extends BaseDaoImpl<Case> implements CaseDao {

	public CaseDaoImpl() {
		super(CaseDao.class);
	}

	public List<Case> getCase(Long id) {
		return this.getSqlSession().selectList(this.getMethodPath("getCase"),id);
	}
	
	 public PageBean<Case> getPage(int currentPage, int pageSize,CasePageBeanDto casePageBeanDto) {
	     
         long beginPosition = (long)(currentPage-1)*pageSize;
         casePageBeanDto.setBeginPosition(beginPosition);
         casePageBeanDto.setEndPosition(beginPosition+pageSize); 
         List<Case> data =  this.getSqlSession().selectList(getMethodPath("getPageByParam"),casePageBeanDto);
         Long allCount = this.getSqlSession().selectOne(getMethodPath("getCountByParam"),casePageBeanDto);
         PageBean<Case> page = new EPageBean<Case>(pageSize,data,allCount,currentPage);
         return page;
     }
}