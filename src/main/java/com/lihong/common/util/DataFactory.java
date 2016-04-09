package com.lihong.common.util;

import java.util.List;

import com.lihong.bean.Case;
import com.lihong.service.CaseService;
import com.lihong.service.impl.CaseServiceImpl;


public class DataFactory {
private static DataFactory dataFactory = new DataFactory();
    private CaseService caseService;
    private DataFactory(){
        
    }  
    
    public List<Case> getData(){
    	caseService = new CaseServiceImpl();
        return caseService.getAll();
        
    }
    
    public static DataFactory getInstance(){
        return dataFactory;
    }
}