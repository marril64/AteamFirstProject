package kr.co.ict;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ReviewrDAO;
import kr.co.ict.domain.ReviewrVO;
import kr.co.ict.domain.StoreInfoDAO;
import kr.co.ict.domain.StoreInfoVO;

/**
 * Servlet implementation class StroreInfoUpdate
 */
@WebServlet("/StroreInfoUpdate")
public class StroreInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StroreInfoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String strStoreNum = request.getParameter("storenum");
		int storeNum = Integer.parseInt(strStoreNum);
		
		String storeName =request.getParameter("storeName");
		String storeContent =request.getParameter("storeContent");
		String storeTime =request.getParameter("storeTime");
		String storeAdd = request.getParameter("storeAdd");
		int storePhone = Integer.parseInt(request.getParameter("storePhone"));
		String menu = request.getParameter("menu");
		int StoreNum = Integer.parseInt(request.getParameter("storeNum"));	
		int storeHit = Integer.parseInt(request.getParameter("storeHit"));
		
        StoreInfoDAO dao = StoreInfoDAO.getInstance();
        StoreInfoVO storeinfo = dao.storeinfoupdate(storeName, storeContent, storeTime, storeAdd, storePhone, menu, StoreNum, storeHit);
		

        response.sendRedirect("http://localhost:8181/AteamFirstProject/getStoreInfoDetail?storeNum=" + StoreNum);
	}

}
