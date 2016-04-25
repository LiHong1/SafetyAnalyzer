package com.lihong.common.util;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.lihong.bean.MenuItem;
import com.lihong.dto.MenuItemDto;
import com.lihong.service.MenuItemService;


/**
 * Created by li hong on 2015/6/25.
 */
public class CacheUtil {
    private static CacheManager cacheManager = CacheManager.create();  
    


   /*     public static SystemDto getSystemConfiguration(SystemConfiguration configuration) {
            CacheManager manager = CacheManager.newInstance();
            Cache systemConfigCache = manager.getCache("systemConfigCache");
            Object object = systemConfigCache.get("systemConfig");
    
            if(object == null){
                SystemDto systemDto;
                systemDto = new SystemDto();
                String loginAble = (String) configuration.getProperty("loginAble");
                String replaceMachineAble = (String) configuration.getProperty("replaceMachineAble");
                String size = (String) configuration.getProperty("jobArea");
                String startTermTime = (String) configuration.getProperty("startTerm");
                String fileRoot = (String) configuration.getProperty("fileRoot");
                systemDto.setLoginAble(Boolean.parseBoolean(loginAble));
                systemDto.setReplaceMachineAble(Boolean.parseBoolean(replaceMachineAble));
                systemDto.setJobArea(Integer.parseInt(size));
                systemDto.setStartTermTime(startTermTime);
                systemDto.setFileRoot(fileRoot);
                systemConfigCache.put(new Element("systemConfig", systemDto));
            }
            return (SystemDto)systemConfigCache.get("systemConfig").getObjectValue();
        }*/
        


        public static  <T> List<T> getCatche(MenuItemService menuItemService,Method method){
            
            
            return null;
           /* CacheManager manager = CacheManager.getInstance();
            Cache menuCache = manager.getCache("menuCache");
            Object object = menuCache.get("menuItems");
            if(object == null){
                List<MenuItem> menuItems = menuService.getAll();
                menuCache.put(new Element("menuItems",menuItems));
            }
            return menuCache.get("menuItems").getObjectValue();*/
        }
        
        public static List<MenuItemDto> getMenuCatche(MenuItemService menuItemService) {
              
            Cache menuCache;
                try {
                    menuCache = cacheManager.getCache("menuCache");
                    Object object = menuCache.get("menuItems");
                    if(object == null){
                        List<MenuItemDto> menuItems = menuItemService.getAll();
                        menuCache.put(new Element("menuItems",(Serializable) menuItems));
                    }
                    return (List<MenuItemDto>) menuCache.get("menuItems").getObjectValue();
                } catch (CacheException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                   return null;
                
        }
        
        public static void updateCatche(String name,List<MenuItem> menuItems) throws CacheException{
           /* CacheManager manager = CacheManager.getInstance();
            //menuCache.put(new Element("menuItems",menuItems));
            Cache menuCache = manager.getCache("menuCache");
            Object object = menuCache.get("menuItems");
            if(object == null){
                List<MenuItem> menuItems = menuService.getAll();
                menuCache.put(new Element("menuItems",menuItems));
            }
            return menuCache.get("menuItems").getObjectValue();*/

        }
}

