package com.lihong.dao.impl;

import java.util.List;

import com.lihong.bean.Dictionary;
import com.lihong.common.daoImpl.BaseDaoImpl;
import com.lihong.dao.DictionaryDao;

public class DictionaryDaoImpl extends BaseDaoImpl<Dictionary> implements DictionaryDao{
       
    public DictionaryDaoImpl() {
        super(DictionaryDao.class);
    }

    public List<Dictionary> getByName(String name){
        
        return this.getSqlSession().selectList(this.getMethodPath("getByName"),name);
    }
}
