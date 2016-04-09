package com.lihong.service;

import java.util.List;

import com.lihong.bean.Case;
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

}
