package com.lihong.dao.impl;

import java.util.List;

import com.lihong.bean.CaseIndex;
import com.lihong.bean.User;
import com.lihong.common.bean.DPageBean;
import com.lihong.common.bean.PageBean;
import com.lihong.common.daoImpl.BaseDaoImpl;
import com.lihong.dao.CaseIndexDao;
import com.lihong.dto.CaseIndexPageBeanDto;

public class CaseIndexDaoImpl extends BaseDaoImpl<CaseIndex> implements CaseIndexDao {

	public CaseIndexDaoImpl() {
		super(CaseIndexDao.class);
	}
	
	 public PageBean<CaseIndex> getPage(Integer currentPage, Integer pageSize, CaseIndexPageBeanDto caseIndexPageBeanDto) {
        long beginPosition = (long)(currentPage-1)*pageSize;
        caseIndexPageBeanDto.setBeginPosition(beginPosition);
        caseIndexPageBeanDto.setEndPosition(beginPosition+pageSize); 
        List<CaseIndex> data =  this.getSqlSession().selectList(getMethodPath("getPageByParam"),caseIndexPageBeanDto);
        Long allCount = this.getSqlSession().selectOne(getMethodPath("getCountByParam"),caseIndexPageBeanDto);
        PageBean<CaseIndex> page = new DPageBean<CaseIndex>(pageSize,data,allCount,currentPage);
        return page;
    }

}