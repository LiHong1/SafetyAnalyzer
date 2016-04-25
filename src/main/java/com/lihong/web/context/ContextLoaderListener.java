package com.lihong.web.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.ContextLoader;

public class ContextLoaderListener extends ContextLoader implements
        ServletContextListener {
    public static final String CONTEXT_PATH = "basePath";

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = getCurrentWebApplicationContext()
                .getServletContext();
        String s = servletContext.getContextPath();
        servletContext.setAttribute(CONTEXT_PATH,
                servletContext.getContextPath());
        System.out.println(s);

    }

    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }

}
