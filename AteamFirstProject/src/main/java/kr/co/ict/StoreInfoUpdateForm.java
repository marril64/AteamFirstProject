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
 * Servlet implementation class StroreInfoUpdateForm
 */
@WebServlet("/StroreInfoUpdateForm")
public class StoreInfoUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreInfoUpdateForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String StoreNum = request.getParameter("storeNum");
		// 정수로 바꿔줘야함.
		int storeNum = Integer.parseInt(StoreNum);
		
		StoreInfoDAO dao = StoreInfoDAO.getInstance();
		StoreInfoVO storeinfo = dao.getstoreinfoDetail(storeNum);
	System.out.println(storeinfo);
	// 바인딩해주세요.
	request.setAttribute("storeinfo", storeinfo);
	// 포워딩해주세요.(/board/boardDetail.jsp로)
	RequestDispatcher dp = request.getRequestDispatcher("/storeinfo/storeinfoUpdateForm.jsp");
	dp.forward(request, response);
	}

}
