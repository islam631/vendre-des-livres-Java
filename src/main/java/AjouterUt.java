
import java.io.IOException;

import Beans.Client_Beans;
import Beans.CompteCL;
import Beans.VillCl_Beans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AjouterUt")
public class AjouterUt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AjouterUt() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom1 = request.getParameter("nomUt");
		String prenom1 = request.getParameter("prenomUt");
		String dateN1 = request.getParameter("dateNUt");
		String NmrT1 = request.getParameter("telephoneUt");
		
		String pay1 = request.getParameter("paysUt");
		String villee = request.getParameter("villeUt");
		
		String emai21 = request.getParameter("emailUt");
		String motDp2 = request.getParameter("passwordUt");
		
		Beans.VillCl_Beans ville2 = new VillCl_Beans
				
				(
				0,
				pay1,
				villee
				);
		
		DAO.VillCl_DAO.create_VillCl(pay1, villee);
		
		
		
		Beans.Client_Beans client = new Client_Beans
				
				(
				0,
				nom1,
				prenom1,
				dateN1,
				Integer.valueOf(NmrT1), 	
				DAO.VillCl_DAO.GetId_VillCl(pay1, villee)
				);
		
		DAO.Client_DAO.create_Client(client.getNOM_CL(), client.getPRENOM_CL(), client.getDATEN_CL(),
				client.getTEL_CL() , client.getID_VILLE());
		
		
		
		Beans.CompteCL compteClient = new CompteCL
				(
				0,
				emai21,
				motDp2,
				0
				);
		DAO.CompteCL_DAO.create_CompteCL(emai21, motDp2, DAO.Client_DAO.get_max_id_client());
		
		

		request.getRequestDispatcher("admin/SupUt.jsp").include(request, response);		
		
		
		
	}

}
