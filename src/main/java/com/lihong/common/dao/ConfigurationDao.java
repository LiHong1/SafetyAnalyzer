package com.lihong.common.dao;



import java.util.List;

import com.lihong.bean.ConfigurationItem;

/**
 * 配置项Dao接口
 *
 * @author lihong
 */
public interface ConfigurationDao extends BaseDao<ConfigurationItem>{

    /**
     * 新增配置项
     *
     * @param key
     * @param value
     */
    void save(String key, String value);

    /**
     * 获取配置项总数
     *
     * @return
     */
    long getKeyCount();

    /**
     * 新增配置项
     *
     * @param item
     */
    void save(ConfigurationItem item);

    /**
     * 获取配置项值
     *
     * @param key
     * @return
     */
    ConfigurationItem get(String key);

    /**
     * 获取所有配置项
     *
     * @return
     */
    List<ConfigurationItem> getAll();

    /**
     * 删除配置项
     *
     * @param item
     */
    void delete(ConfigurationItem item);

    /**
     * 更新配置项
     *
     * @param item
     */
    void update(ConfigurationItem item);




}