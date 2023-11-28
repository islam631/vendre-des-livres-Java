
import java.io.IOException;

import Beans.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AjouterAd")
public class AjouterAd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AjouterAd() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String nomAdm = request.getParameter("nomAd");
		String prenomAdm = request.getParameter("prenomAd");
		String emailAdm = request.getParameter("emailAd");
		String passwordAdm = request.getParameter("passwordAd");
		
		Beans.Admin admin = new Admin
				(
				0,
				nomAdm,
				prenomAdm,
				emailAdm,
				passwordAdm
				);
		
		DAO.Admin_DAO.create_Admin
				(
				nomAdm,
				prenomAdm,
				emailAdm,
				passwordAdm
				);
		

		request.getRequestDispatcher("admin/SupAd.jsp").include(request, response);
		
	}

}
