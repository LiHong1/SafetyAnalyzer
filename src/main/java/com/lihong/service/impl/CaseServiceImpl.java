package com.lihong.service.impl;

import java.util.List;

import com.lihong.bean.Case;
import com.lihong.dao.CaseDao;
import com.lihong.service.CaseService;

public class CaseServiceImpl extends BaseServiceImpl<Case> implements CaseService{

	public List<Case> getCase(Long id) {
		Case c;
		List<Case> cases = ((CaseDao)baseDao).getCase(id);
		if(cases.size()==3){
			c = cases.get(1);
			cases.set(1, cases.get(0));
			cases.set(0, c);
		}else if(cases.size()==2){
			if(cases.get(1).getId()==id){
				c = cases.get(1);
				cases.set(1, cases.get(0));
				cases.set(0, c);
			}
		}
		return cases;
	}
	
}
