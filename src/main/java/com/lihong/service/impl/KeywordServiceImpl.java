package com.lihong.service.impl;
import com.lihong.bean.Keyword;
import com.lihong.dao.KeywordDao;
import com.lihong.service.KeywordService;
public class KeywordServiceImpl extends BaseServiceImpl<Keyword> implements KeywordService {
    /**
     * 
     */
	public Keyword getByWord(String string) {
		return ((KeywordDao)baseDao).getByWord(string);
	}
	
}
