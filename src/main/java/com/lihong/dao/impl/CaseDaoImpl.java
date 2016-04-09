package com.lihong.dao.impl;

import java.util.List;

import com.lihong.bean.Case;
import com.lihong.dao.CaseDao;

public class CaseDaoImpl extends BaseDaoImpl<Case> implements CaseDao {

	public CaseDaoImpl() {
		super(CaseDao.class);
	}

	public List<Case> getCase(Long id) {
		return this.getSqlSession().selectList(this.getMethodPath("getCase"),id);
	}
	

}
