package com.lihong.service;

import com.lihong.bean.Keyword;

public interface KeywordService extends BaseService<Keyword> {
	
	 /**
     * 根据关键字名称获取关键字
     * @param string
     * @return
     */
	Keyword getByWord(String string);
}
