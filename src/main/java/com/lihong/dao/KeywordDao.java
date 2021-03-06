package com.lihong.dao;

import com.lihong.bean.Keyword;
import com.lihong.common.dao.BaseDao;

public interface KeywordDao extends BaseDao<Keyword>{
 
    /**
     * 根据关键字名称获取关键字
     * @param string
     * @return
     */
	Keyword getByWord(String string);
	
}
