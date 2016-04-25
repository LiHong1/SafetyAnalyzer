package com.lihong.dto;

import com.lihong.bean.Case;
import com.lihong.bean.DomainObject;
import com.lihong.bean.Message;
import com.lihong.bean.User;
/**
 *
 * 
 * @author li hong
 * 
 */
public class MessageDto{


    private Integer type;
    private Long userId;
    
    private int beginPosition;
    private int endPosition;
    private int size;
    
    public int getBeginPosition() {
        return beginPosition;
    }
    public void setBeginPosition(int beginPosition) {
        this.beginPosition = beginPosition;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }



    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
    public MessageDto(Integer type, Long userId, int beginPosition, int size) {
        super();
        this.type = type;
        this.userId = userId;
        this.beginPosition = beginPosition;
        this.size = size;
    }
    public MessageDto(){
        super();
    }
    public int getEndPosition() {
        this.setEndPosition(this.getBeginPosition()+this.getSize());
        return endPosition;
    }
    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

}
