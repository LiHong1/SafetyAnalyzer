package com.lihong.web.service.quartz;

import java.util.List;

import com.lihong.bean.Case;
import com.lihong.service.CaseService;

public class UpdateCaseIndexJob {
    
    private CaseService caseService;
    
    public CaseService getCaseService() {
        return caseService;
    }
    
    public void setCaseService(CaseService caseService) {
        this.caseService = caseService;
    }

    public void execute(){
        List<Case> cases = caseService.getAll();
        System.out.println(cases.size());
    }
}
