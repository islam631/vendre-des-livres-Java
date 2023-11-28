

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/SrSpUt")
public class SrSpUt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SrSpUt() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		DAO.Client_DAO.delete_and_Order_ID_CL_asc(id);

		request.getRequestDispatcher("admin/SupUt.jsp").include(request, response);	
		}

	
	

}
