package listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;


public class MyListener implements ServletContextListener{

    // Public constructor is required by servlet spec
    public MyListener (){
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized (ServletContextEvent sce){
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
      System.out.println("服务器启动，初始化成功");
    }

    public void contextDestroyed (ServletContextEvent sce){
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
        System.out.println("webService stop");
        try {
            while(DriverManager.getDrivers().hasMoreElements()) {
                DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
            }
            System.out.println("jdbc Driver close");
            AbandonedConnectionCleanupThread.checkedShutdown();
            Thread.sleep(2000);
            System.out.println("clean thread success");
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    }





