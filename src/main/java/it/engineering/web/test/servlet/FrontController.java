package it.engineering.web.test.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;

import it.engineering.web.test.controller.ApplicationController;
import it.engineering.web.test.view.ViewResolver;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ApplicationController applicationController;
	@Autowired
	private ViewResolver viewResolver;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	 ApplicationContext applicationContext = 
 				(ApplicationContext) config.getServletContext().getAttribute("application-context");
 		
 		AutowireCapableBeanFactory acbf = applicationContext.getAutowireCapableBeanFactory();
 		acbf.autowireBean(this);
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		processRequest(request,response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = applicationController.processRequest(request, response);
		System.out.println("view: " + view);
		System.out.println("page: " + viewResolver.getPage(view));
		//na osnovu pogleda vrati konkretnu stranicu korisniku
		request.getRequestDispatcher(viewResolver.getPage(view)).forward(request, response);
	}

}
