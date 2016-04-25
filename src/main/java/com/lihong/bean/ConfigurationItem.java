package com.lihong.bean;



/**
 * 配置项
 *
 * @author lihong
 */

public class ConfigurationItem extends  DomainObject{
    //配置键名
    private String key;
    //配置值
    private String value;
    //值类型（未使用）
    private String valueType;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

}