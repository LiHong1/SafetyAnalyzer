package com.lihong.web.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lihong.service.CaseService;

@Component
public class TimeTask implements Job {

    @Autowired
    private CaseService caseService;
    
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        
    }

}
