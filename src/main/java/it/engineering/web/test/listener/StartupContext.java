package it.engineering.web.test.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.engineering.web.test.config.BeanConfiguration;
import it.engineering.web.test.domain.User;

/**
 * Application Lifecycle Listener implementation class StartupContext
 *
 */
public class StartupContext implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public StartupContext() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext servletContext=sce.getServletContext();
    	List<User> users = new ArrayList<>();
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
    	servletContext.setAttribute("application-context", applicationContext);
    	servletContext.setAttribute("loggedUsers", users);
    }
	
}
