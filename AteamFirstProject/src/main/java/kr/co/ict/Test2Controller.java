package kr.co.ict;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.*;
import kr.co.ict.service.Test2DeleteService;
import kr.co.ict.service.Test2ExcelService;
import kr.co.ict.service.Test2FormService;
import kr.co.ict.service.Test2GenderService;
import kr.co.ict.service.Test2SearchService;
import kr.co.ict.service.Test2Service;
import kr.co.ict.service.Test2UpdateService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.test2")
public class Test2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2Controller() {
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
		String ui = null;
		Test2DAO dao = Test2DAO.getInstance();
		Test2Service sv = null;
		
		String tNum = request.getParameter("tNum");
		String tId = request.getParameter("tId");
		String tName = request.getParameter("tName");
		String tGender = request.getParameter("tGender");
		String tCountry = request.getParameter("tCountry");
		String tCity = request.getParameter("tCity");
		
		
		if (uri.equals("/AteamFirstProject/firstProject/test2.test2")) {
			sv = new Test2FormService();
			sv.execute(request, response);
			ui = "/firstProject/gender.test2?tGender=";
		} else if (uri.equals("/AteamFirstProject/firstProject/update.test2")) {
			sv = new Test2UpdateService();
			sv.execute(request, response);
			ui = "/firstProject/test2.jsp";
		} else if (uri.equals("/AteamFirstProject/firstProject/delete.test2")) {
			sv = new Test2DeleteService();
			sv.execute(request, response);
			ui = "/firstProject/test2.jsp";
		} else if (uri.equals("/AteamFirstProject/firstProject/excel.test2")) {
			sv = new Test2ExcelService();
			sv.execute(request, response);
			ui = "/firstProject/test2.jsp";
		} else if (uri.equals("/AteamFirstProject/firstProject/search.test2")) {
			sv = new Test2SearchService();
			sv.execute(request, response);
			ui = "/firstProject/test2.jsp?tNum=" + tNum + "&tId=" + tId + "&tName=" + tName + "&tGender=" + tGender + "&tCountry" + tCountry + "&tCity" + tCity;
		} else if (uri.equals("/AteamFirstProject/firstProject/gender.test2")) {
			sv = new Test2GenderService();
			sv.execute(request, response);
			ui = "/firstProject/test2.jsp";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}

}