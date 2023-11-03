package com.py.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
    private static final Logger logger = LoggerFactory.getLogger(MyContextListener.class);
    private SSHConnection conexionssh;


    public MyContextListener() {
        super();
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        logger.info("Context initialized ... !");
        System.out.println("Context initialized ... !");
        try {
            conexionssh = new SSHConnection();
        } catch (Throwable e) {
            e.printStackTrace(); // error connecting SSH server
        }
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        logger.info("Context destroyed ... !");
        System.out.println("Context destroyed ... !");
        conexionssh.closeSSH(); // disconnect
    }
}
