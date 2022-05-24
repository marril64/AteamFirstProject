package kr.co.ict;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.StoreInfoDAO;
import kr.co.ict.service.IStoreinfoService;
import kr.co.ict.service.StoreinfoDeleteService;
import kr.co.ict.service.StoreinfoDetailService;
import kr.co.ict.service.StoreinfoInsertService;
import kr.co.ict.service.StoreinfoListService;
import kr.co.ict.service.StoreinfoUpdateFormService;
import kr.co.ict.service.StoreInfoUpdateService;



/**
 * Servlet implementation class StoreController
 */
@WebServlet("*.do")
public class StoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreController() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doRequest(request, response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);		
		}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		// 포워딩시 .jsp주소의 경로를 미리 저장할 변수
		String ui = null;
		// dao생성
		StoreInfoDAO dao = StoreInfoDAO.getInstance();
		// 어떤 종류의 서비스라도 다 받을 수 있는 서비스 인터페이스 생성
		IStoreinfoService sv = null;
		
		if(uri.equals("/AteamFirstProject/getStoreInfoList.do")) {
			// 서비스 생성
			sv = new StoreinfoListService();
			// 서비스의 .execute(request, response) 호출
			sv.execute(request, response);
			ui = "/storeinfo/getStoreInfoList.jsp";
		}else if(uri.equals("/AteamFirstProject/getStoreInfoDetail.do")) {
			sv = new StoreinfoDetailService();
			sv.execute(request, response);
			ui = "/storeinfo/storeinfoDetail.jsp";
		}else if(uri.equals("/storeinfo/storeinfoInsertForm.jsp")) {
			// 글쓰기 창으로 넘어가는 로직
			// 로직이 없어서 ui 로 연결해주는것만으로도 충분함
			ui = "/storeinfo/storeinfoInsertForm.jsp";
		}else if(uri.equals("/AteamFirstProject/storeinfoinsert.do")) {
			sv = new StoreinfoInsertService();
			sv.execute(request, response);
			// /boardList로 리다이렉트(서블릿 주소로 리다이렉트시 파일이름 노출 안됨.)
			ui = "/getStoreInfoList.do";// 리다이렉트시는 폴더명 없이 마지막 주소만 적습니다.
		}else if(uri.equals("/AteamFirstProject/storeinfodelete.do")) {
			sv = new StoreinfoDeleteService();
			sv.execute(request, response);
			// boardList로 리다이렉트
			ui = "/getStoreInfoList.do";
		}else if(uri.equals("/AteamFirstProject/storeinfoUpdateForm.do")) {
			sv = new StoreinfoUpdateFormService();
			sv.execute(request, response);
			// 포워딩
			ui = "/storeinfo/storeinfoUpdateForm.jsp";
		}else if(uri.equals("/storeinfo/StoreInfoUpdate.do")) {
			sv = new StoreInfoUpdateService();
			sv.execute(request, response);
			// 리다이렉트(boardNum번 detail페이지로 이동.)
			ui = "/getStoreInfoDetail.do?storeNum=" + request.getParameter("storeNum");
		}
		
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}
	
}
