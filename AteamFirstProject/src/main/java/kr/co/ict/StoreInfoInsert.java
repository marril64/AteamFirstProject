package kr.co.ict;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ReviewrDAO;
import kr.co.ict.domain.StoreInfoDAO;
import kr.co.ict.domain.StoreInfoVO;

/**
 * Servlet implementation class StoreInsert
 */
@WebServlet("/storeinfoinsert")
public class StoreInfoInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreInfoInsert() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");

				String storeName =request.getParameter("storeName");
				String storeContent =request.getParameter("storeContent");
				String storeTime =request.getParameter("storeTime");
				String storeAdd = request.getParameter("storeAdd");
				String storePhone = request.getParameter("storePhone");
				String menu = request.getParameter("menu");	
				int storeHit = Integer.parseInt(request.getParameter("storeHit"));
				
				// System.out.println(storeName + ", " + storeContent + ", " + storeTime + ", " + storeAdd + ", " + storePhone + ", " +  menu  + ", " + storeHit);
				
				StoreInfoDAO dao = StoreInfoDAO.getInstance();
				dao.storeinfoInsert(storeName, storeContent, storeTime, storeAdd, storePhone, menu);
		        response.sendRedirect("http://localhost:8181/AteamFirstProject/getstoreinfoList.do");
			
		      
	}

}
