package kr.co.ict;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ReviewrDAO;
import kr.co.ict.domain.ReviewrVO;

/**
 * Servlet implementation class GetReviewrList
 */
@WebServlet("/getreviewrlist")
public class GetReviewrList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReviewrList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewrDAO dao = ReviewrDAO.getInstance();
		List<ReviewrVO> reviewrList = dao.getreviewrList();
		System.out.println("데이터를 받아오는지 확인" + reviewrList);
		
		// 포워딩 위치로 얻어온 데이터 보내기.(ServletCustom을 참고하세요.)
				request.setAttribute("reviewrList", reviewrList);
				// 포워딩으로 getBoardList.jsp와 연결해보겠습니다.
				RequestDispatcher dp = request.getRequestDispatcher("/review/getReviewrList.jsp");
				dp.forward(request, response);
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
