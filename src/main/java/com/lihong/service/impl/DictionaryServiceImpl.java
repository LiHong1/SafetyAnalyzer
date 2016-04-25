package com.lihong.service.impl;

import java.util.List;

import com.lihong.bean.Case;
import com.lihong.bean.Dictionary;
import com.lihong.dao.CaseDao;
import com.lihong.dao.DictionaryDao;
import com.lihong.service.DictionaryService;

public class DictionaryServiceImpl extends BaseServiceImpl<Dictionary> implements DictionaryService{

    public List<Dictionary> getByName(String name) {
        return ((DictionaryDao)baseDao).getByName(name);
    }


	
}
