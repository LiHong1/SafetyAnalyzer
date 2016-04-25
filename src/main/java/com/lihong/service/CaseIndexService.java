package com.lihong.service;

import java.io.InputStream;
import java.util.List;

import com.lihong.bean.Case;
import com.lihong.bean.CaseIndex;
import com.lihong.common.bean.DPageBean;
import com.lihong.common.bean.PageBean;
import com.lihong.dto.CaseDto;
import com.lihong.dto.CaseIndexPageBeanDto;
/**
 * 案例的service
 * @author lihong2-ext
 *
 */
public interface CaseIndexService extends BaseService<CaseIndex>{
    
	
	
    public PageBean<CaseIndex> getPage(Integer currentPage, Integer pageSize, CaseIndexPageBeanDto caseIndexPageBeanDto) ;

}
