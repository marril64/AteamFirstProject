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
import kr.co.ict.service.Test1DeleteService;
import kr.co.ict.service.Test1ExcelService;
import kr.co.ict.service.Test1FormService;
import kr.co.ict.service.Test1SearchService;
import kr.co.ict.service.Test1Service;
import kr.co.ict.service.Test1UpdateService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.test1")
public class Test1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test1Controller() {
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
		Test1DAO dao = Test1DAO.getInstance();
		Test1Service sv = null;
		
		if (uri.equals("/AteamFirstProject/firstProject/test1.test1")) {
			sv = new Test1FormService();
			sv.execute(request, response);
			ui = "/firstProject/test1.jsp";
		} else if (uri.equals("/AteamFirstProject/firstProject/update.test1")) {
			sv = new Test1UpdateService();
			sv.execute(request, response);
			ui = "/firstProject/test1.jsp";
		} else if (uri.equals("/AteamFirstProject/firstProject/delete.test1")) {
			sv = new Test1DeleteService();
			sv.execute(request, response);
			ui = "/firstProject/test1.jsp";
		} else if (uri.equals("/AteamFirstProject/firstProject/excel.test1")) {
			sv = new Test1ExcelService();
			sv.execute(request, response);
			ui = "/firstProject/test1.jsp";
		} else if (uri.equals("/AteamFirstProject/firstProject/search.test1")) {
			sv = new Test1SearchService();
			sv.execute(request, response);
			ui = "/firstProject/test1.jsp";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}

}
