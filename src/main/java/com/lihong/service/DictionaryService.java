package com.lihong.service;

import java.util.List;

import com.lihong.bean.Case;
import com.lihong.bean.Dictionary;
/**
 * 案例的service
 * @author lihong2-ext
 *
 */
public interface DictionaryService extends BaseService<Dictionary>{
    
	/**
	 * 获取字典值
	 * @param id
	 * @return
	 */
    public List<Dictionary> getByName(String name);
    



}
