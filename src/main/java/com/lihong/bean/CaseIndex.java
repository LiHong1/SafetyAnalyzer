package com.lihong.bean;

import java.util.Date;


/**
 *
 * 
 * @author li hong
 * 
 */
public class CaseIndex extends DomainObject{

    public CaseIndex() {
        super();
    }

    private Long caseId;
    private String title;
	private Character operate;  //0 新增  1 修改  2 删除

 
    public Character getOperate() {
        return operate;
    }

    public void setOperate(Character operate) {
        this.operate = operate;
    }



    public CaseIndex(Case c, Character operate) {
        this.setCaseId(c.getId());
        this.setCreatedDate(c.getCreatedDate());
        this.setUpdatedDate(c.getUpdatedDate());
        this.operate = operate;
    }
	
    public CaseIndex(Long caseId, Character operate, Date createdDate,Date updatedDate) {
        this.setId(caseId);
        this.setCreatedDate(createdDate);
        this.setUpdatedDate(updatedDate);
        this.operate = operate;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   
}
