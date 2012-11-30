package learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet implements javax.servlet.Servlet {

	    /* (non-Java-doc)
		 * @see javax.servlet.http.HttpServlet#HttpServlet()
		 */
		public HelloWorldServlet() {
			super();
		}   	
		
		/* (non-Java-doc)
		 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, 
		     HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		    throws ServletException, IOException {
			response.getWriter().write("Hello, world!");
		}  	
		
		/* (non-Java-doc)
		 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, 
		     HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		    throws ServletException, IOException {
			// TODO Auto-generated method stub
		}   	
}
