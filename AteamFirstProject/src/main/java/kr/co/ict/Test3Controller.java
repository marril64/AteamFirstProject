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
import kr.co.ict.service.Test3DeleteService;
import kr.co.ict.service.Test3ExcelService;
import kr.co.ict.service.Test3FormService;
import kr.co.ict.service.Test3GenderService;
import kr.co.ict.service.Test3SearchService;
import kr.co.ict.service.Test3Service;
import kr.co.ict.service.Test3UpdateService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.test3")
public class Test3Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test3Controller() {
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
		Test3DAO dao = Test3DAO.getInstance();
		Test3Service sv = null;
		
		String tNum = request.getParameter("tNum");
		String tId = request.getParameter("tId");
		String tName = request.getParameter("tName");
		String tGender = request.getParameter("tGender");
		String tCountry = request.getParameter("tCountry");
		String tCity = request.getParameter("tCity");
		
		
		if (uri.equals("/AteamFirstProject/firstProject/test3.test3")) {
			sv = new Test3FormService();
			sv.execute(request, response);
			ui = "/firstProject/gender.test3?tGender=";
		} else if (uri.equals("/AteamFirstProject/firstProject/update.test3")) {
			sv = new Test3UpdateService();
			sv.execute(request, response);
			ui = "/firstProject/test3.jsp";
		} else if (uri.equals("/AteamFirstProject/firstProject/delete.test3")) {
			sv = new Test3DeleteService();
			sv.execute(request, response);
			ui = "/firstProject/test3.jsp";
		} else if (uri.equals("/AteamFirstProject/firstProject/excel.test3")) {
			sv = new Test3ExcelService();
			sv.execute(request, response);
			ui = "/firstProject/test3.jsp";
		} else if (uri.equals("/AteamFirstProject/firstProject/search.test3")) {
			sv = new Test3SearchService();
			sv.execute(request, response);
			ui = "/firstProject/test3.jsp?tNum=" + tNum + "&tId=" + tId + "&tName=" + tName + "&tGender=" + tGender + "&tCountry" + tCountry + "&tCity" + tCity;
		} else if (uri.equals("/AteamFirstProject/firstProject/gender.test3")) {
			sv = new Test3GenderService();
			sv.execute(request, response);
			ui = "/firstProject/test3.jsp";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}

}