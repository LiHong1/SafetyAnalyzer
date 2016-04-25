package com.lihong.dao;

import java.util.List;

import com.lihong.bean.Dictionary;
import com.lihong.common.dao.BaseDao;

public interface DictionaryDao extends BaseDao<Dictionary>{
       
    public List<Dictionary> getByName(String name);
}
