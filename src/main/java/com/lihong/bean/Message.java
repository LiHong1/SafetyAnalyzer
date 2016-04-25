package com.lihong.bean;

public class Message extends DomainObject{
    
    /**
     * 
     */
    private static final long serialVersionUID = 4678435636135171798L;
      
    private String content;
    private String dangerousKeywords;
    private Integer type;
    private Case c;
    private User u;
    private String strangePhone;
    private String userPhone;
    
    
   
    public Message(String content, String dangerousKeywords, Integer type,
            Case c, User u, String strangePhone) {
        super();
        this.content = content;
        this.dangerousKeywords = dangerousKeywords;
        this.type = type;
        this.c = c;
        this.u = u;
        this.strangePhone = strangePhone;
    }
    
    public Message(String content, String dangerousKeywords, Integer type,String userPhone,
            String strangePhone) {
        super();
        this.content = content;
        this.dangerousKeywords = dangerousKeywords;
        this.type = type;
        this.userPhone = userPhone;
        this.strangePhone = strangePhone;
    }
    

    public Message() {
        super();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDangerousKeywords() {
        return dangerousKeywords;
    }
    public void setDangerousKeywords(String dangerousKeywords) {
        this.dangerousKeywords = dangerousKeywords;
    }
    public Case getC() {
        return c;
    }
    public void setC(Case c) {
        this.c = c;
    }
    public User getU() {
        return u;
    }
    public void setU(User u) {
        this.u = u;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }

    public String getStrangePhone() {
        return strangePhone;
    }

    public void setStrangePhone(String strangePhone) {
        this.strangePhone = strangePhone;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    
    

}
