
import java.io.IOException;
import Beans.Client_Beans;
import Beans.CompteCL;
import Beans.VillCl_Beans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/CreationCL")
public class CreationCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CreationCL() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String nom = request.getParameter("nom1");
		String prenom = request.getParameter("prenom1");
		String dateN = request.getParameter("dateN1");
		String NmrT = request.getParameter("NmrT1");
		
		String pay = request.getParameter("pay");
		String ville = request.getParameter("ville");
		
		String emai2 = request.getParameter("email2");
		String motDp2 = request.getParameter("password2");
		
		

		Beans.VillCl_Beans ville1 = new VillCl_Beans
				
				(
				0,
				pay,
				ville
				);
		
		DAO.VillCl_DAO.create_VillCl(pay, ville);
		
		
		
		Beans.Client_Beans client = new Client_Beans
				
				(
				0,
				nom,
				prenom,
				dateN,
				Integer.valueOf(NmrT), 	
				DAO.VillCl_DAO.GetId_VillCl(pay, ville)
				);
		
		DAO.Client_DAO.create_Client(client.getNOM_CL(), client.getPRENOM_CL(), client.getDATEN_CL(),
				client.getTEL_CL() , client.getID_VILLE());
		
		
		
		Beans.CompteCL compteClient = new CompteCL
				(
				0,
				emai2,
				motDp2,
				0
				);
		DAO.CompteCL_DAO.create_CompteCL(emai2, motDp2, DAO.Client_DAO.get_max_id_client());
		
		
		
		
		request.setAttribute("nomCl", client);	
		this.getServletContext().getRequestDispatcher("/PPaprSr.jsp").forward(request, response);
		
	}
	

}
