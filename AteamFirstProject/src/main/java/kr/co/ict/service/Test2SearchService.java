package kr.co.ict.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.Test2DAO;
import kr.co.ict.domain.Test2VO;

public class Test2SearchService implements Test2Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tId = request.getParameter("tId");
		String tName = request.getParameter("tName");
		String tGender = request.getParameter("tGender");
		String tCity = request.getParameter("tCity");
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
		
		request.setCharacterEncoding("utf-8");
		Test2DAO dao = Test2DAO.getInstance();
		List<Test2VO> list = dao.test2List();
		list = dao.test2SearchAll(tId, tName, tGender, tCity, date1, date2);

		request.setAttribute("list", list);
		
	}
	
}