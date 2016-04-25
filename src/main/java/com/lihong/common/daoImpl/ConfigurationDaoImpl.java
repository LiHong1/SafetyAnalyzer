package com.lihong.common.daoImpl;


import java.util.List;

import com.lihong.bean.ConfigurationItem;
import com.lihong.common.dao.ConfigurationDao;

/**
 * 配置Dao实现类
 *
 * @author lihong
 */
public class ConfigurationDaoImpl extends BaseDaoImpl<ConfigurationItem> implements ConfigurationDao {
    public ConfigurationDaoImpl() {
        super(ConfigurationDao.class);
    }





    public void save(String key, String value) {
        ConfigurationItem item = new ConfigurationItem();
        item.setKey(key);
        item.setValue(value);
        save(item);
    }


    public void save(ConfigurationItem item) {
        
    }


    public long getKeyCount() {
        long result = this.getSqlSession().selectOne("getCount");
        return result;
    }

    public ConfigurationItem get(String key) {
        return this.getSqlSession().selectOne("");
    }


    public List<ConfigurationItem> getAll() {
        return this.getSqlSession().selectList("");
    }


    public void delete(ConfigurationItem item) {
        this.getSqlSession().delete("");
    }


    public void update(ConfigurationItem item) {
        this.getSqlSession().update("");
    }

}