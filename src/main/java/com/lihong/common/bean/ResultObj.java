package com.lihong.common.bean;

import java.util.List;

public class ResultObj {
    
   private int status; // 0 success 1 failure;
   
   private String message;
   
   private Object value;
   
   private List data;

    public int getStatus() {
        return status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    
    public ResultObj(int status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
    
    public ResultObj(int status, String message,Long value) {
        super();
        this.status = status;
        this.message = message;
        this.value = value;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
       
   

}
