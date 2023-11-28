
import java.io.IOException;
import java.io.PrintWriter;

import Beans.Admin;
import Beans.Client_Beans;
import Beans.CompteCL;
import jakarta.servlet.ServletConfig;
import jakarta.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/LoginUtAd")
public class LoginUtAd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginUtAd() {
        super();
            }



	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("checkAdUt")==null) 
		{
			if (DAO.CompteCL_DAO.connecterUt(request.getParameter("email1"),request.getParameter("password1"))==1)
			{
				Client_Beans nomCl = DAO.CompteCL_DAO.GetClient(request.getParameter("email1"), request.getParameter("password1"));	
				request.setAttribute("nomCl", nomCl);
				request.getRequestDispatcher("PPaprSr.jsp").include(request, response);
				
				
				
			}
			else 
			{
				//request.getRequestDispatcher("PPavantSr.jsp").forward(request, response);
				response.sendRedirect("PPavantSr.jsp");
			}
			
		}
		else if(request.getParameter("checkAdUt").equals("on"))
		{
			if (DAO.Admin_DAO.connecterAd(request.getParameter("email1"),request.getParameter("password1"))==1)
			{
				Admin nomAd = DAO.Admin_DAO.GetAdmin(request.getParameter("email1"), request.getParameter("password1"));	
				request.setAttribute("nomAd", nomAd);
				request.getRequestDispatcher("admin/AjouterLv.jsp").include(request, response);
				
			}
			else 
			{
				//request.getRequestDispatcher("PPavantSr.jsp").forward(request, response);
				response.sendRedirect("PPavantSr.jsp");
			}
		}
		
		
		
	}

}
