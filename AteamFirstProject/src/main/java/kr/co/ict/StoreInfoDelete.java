package kr.co.ict;

import java.io.IOException;
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
 * Servlet implementation class StoreInfoDelete
 */
@WebServlet("/storeinfodelete")
public class StoreInfoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreInfoDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeNum = request.getParameter("storeNum");
		//System.out.println(storeNum);
		// 정수로 바꿔줘야함.
		//int storenum = Integer.parseInt(storeNum);
		//StoreInfoDAO dao = StoreInfoDAO.getInstance();
		//dao.storeinfoDelete(storenum);
		response.sendRedirect("http://localhost:8181/AteamFirstProject/getstoreinfoList");
	}

}
