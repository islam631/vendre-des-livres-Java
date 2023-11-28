import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/SrSpLv")
public class SrSpLv extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SrSpLv() {
        super();
    }
    
    
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		DAO.Livre_DAO.delete_and_Order_ISBN_LV_asc(id);

		request.getRequestDispatcher("admin/SupLv.jsp").include(request, response);	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
	
	}
}
