package com.lihong.service;

import java.io.InputStream;
import java.util.List;

import com.lihong.bean.Case;
import com.lihong.common.bean.PageBean;
import com.lihong.dto.CaseDto;
import com.lihong.dto.CasePageBeanDto;
/**
 * 案例的service
 * @author lihong2-ext
 *
 */
public interface CaseService extends BaseService<Case>{
    
	/**
	 * 获取案例与案例相连两篇的案例
	 * @param id
	 * @return
	 */
	List<Case> getCase(Long id);
	
	/**
	 * 从excel输入流中获取Case
	 * @param inputStream
	 * @return
	 */
	List<CaseDto> getCase(InputStream inputStream);
	
    /**
     * 批量增加Case
     * @param cases
     */
    void add(List<Case> cases);
    
    /**
     * 带参数的查询
     * @param currentPage
     * @param pageSize
     * @param t
     * @return
     */
    public PageBean<Case> getPage(int currentPage,int pageSize,CasePageBeanDto t);
    
    /**
     * 
     * @param caseDtos
     * @return
     */
    public int addCase(List<CaseDto> caseDtos);

}
