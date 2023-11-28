
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/SrSpAd")
public class SrSpAd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SrSpAd() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		DAO.Admin_DAO.delete_and_Order_ID_ADMIN_asc(id);

		request.getRequestDispatcher("admin/SupAd.jsp").include(request, response);		
	}

}
