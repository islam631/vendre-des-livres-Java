
import java.io.IOException;
import Beans.Auteur;
import Beans.Categorielv;
import Beans.Livre;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AjouterLv")
public class AjouterLv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AjouterLv() {
        super();
       
    }

	
	public void init(ServletConfig config) throws ServletException {
		
	}

	
	public void destroy() {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//livre
		String titrelv = request.getParameter("titrelv");
		String prixlv = request.getParameter("prixlv");
		String desclv = request.getParameter("desclv");
		String nmrpagelv = request.getParameter("nmrpagelv");
		String dateprlv = request.getParameter("dateprlv");
		String image = request.getParameter("IMAGE");
		
		//auteur
		String nomaut = request.getParameter("nomaut");
		String prenomaut = request.getParameter("prenomaut");
		String dateNaut = request.getParameter("dateNaut");
		String nationaliteaut = request.getParameter("nationaliteaut");
		
		//categorie
		String nomcateg = request.getParameter("nomcateg");
		String desccateg = request.getParameter("desccateg");
		
		
		
		
		Beans.Auteur auteur = new Auteur
						(
						0,
						nomaut,
						prenomaut,
						Beans.Client_Beans.getDate(dateNaut),
						nationaliteaut
						);
		
		DAO.Auteur_DAO.create_Auteur(nomaut,prenomaut,Beans.Client_Beans.getDate(dateNaut),nationaliteaut);
		
			
		Beans.Categorielv categorie = new Categorielv
						(
						0,
						nomcateg,
						desccateg
						);
		
		DAO.Categorielv_DAO.create_Categorielv(nomcateg,desccateg);
        
		
		Beans.Livre livre = new Livre
				(
				0,
				titrelv,
				Integer.valueOf(prixlv),
				desclv,
				Integer.valueOf(nmrpagelv),
				Beans.Client_Beans.getDate(dateprlv),
				DAO.Categorielv_DAO.GetId_Categorielv(nomcateg),
				image
				);
		
		DAO.Livre_DAO.create_Livre(titrelv, (int) livre.getPRIX_LV(), livre.getDESC_LV(), livre.getNMRPAGE_LV(), livre.getDATEPR_LV(),DAO.Categorielv_DAO.GetId_Categorielv(nomcateg),livre.getIMAGE());
        
		
		request.getRequestDispatcher("admin/SupLv.jsp").include(request, response);
	}

}
