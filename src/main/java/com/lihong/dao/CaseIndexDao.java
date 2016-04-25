package com.lihong.dao;

import java.util.List;

import com.lihong.bean.CaseIndex;
import com.lihong.common.bean.DPageBean;
import com.lihong.common.bean.PageBean;
import com.lihong.common.dao.BaseDao;
import com.lihong.dto.CaseIndexPageBeanDto;

public interface CaseIndexDao extends BaseDao<CaseIndex>{

    public PageBean<CaseIndex> getPage(Integer currentPage, Integer pageSize, CaseIndexPageBeanDto caseIndexPageBeanDto);
}
