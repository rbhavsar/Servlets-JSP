package com.listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TestListner
 *
 */
@WebListener
public class TestListner implements ServletContextListener { // implements ServletContextListener

    /**
     * Default constructor. 
     */
    public TestListner() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { // destroy
    	System.out.println(" --- Server stopped --- ");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { // initialized
    	System.out.println(" --- Server started --- ");
    }
	
}
