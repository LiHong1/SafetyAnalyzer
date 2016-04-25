package com.lihong.service.impl;

import com.lihong.bean.CaseIndex;
import com.lihong.common.bean.PageBean;
import com.lihong.dao.CaseIndexDao;
import com.lihong.dto.CaseIndexPageBeanDto;
import com.lihong.service.CaseIndexService;

public class CaseIndexServiceImpl extends BaseServiceImpl<CaseIndex> implements CaseIndexService{

    public PageBean<CaseIndex> getPage(Integer currentPage, Integer pageSize,
            CaseIndexPageBeanDto caseIndexPageBeanDto) {
        return ((CaseIndexDao)baseDao).getPage(currentPage, pageSize,caseIndexPageBeanDto);
    }

 

}
