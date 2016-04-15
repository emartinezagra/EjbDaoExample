package es.uem.aju.rt.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uem.aju.rp.business.IDummyRemote;


/**
 * Servlet implementation class DumyServlet
 */
public class DumyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L; 

	@EJB
	private IDummyRemote dummyEJBService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DumyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		PrintWriter out = response.getWriter();
		if (dummyEJBService != null){
			out.println("<h1>"+dummyEJBService.findDummyPersonByID(new Long(1))+"</h1>");
			out.println("<h1>"+dummyEJBService.findDummyPersonByCity("Barcelona")+"</h1>");
		}else{
			out.println("<h1>EJB nooo inyectado</h1>");
		}					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if (dummyEJBService != null){
			out.println("<h1>"+dummyEJBService.dummyRTMethod()+"</h1>");
		}else{
			out.println("<h1>EJB no inyectado</h1>");
		}
	}
}
