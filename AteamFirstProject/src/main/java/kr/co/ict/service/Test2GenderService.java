package kr.co.ict.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.Test2DAO;
import kr.co.ict.domain.Test2VO;

public class Test2GenderService implements Test2Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tGender = request.getParameter("tGender");
		
		request.setCharacterEncoding("utf-8");
		Test2DAO dao = Test2DAO.getInstance();
		List<Test2VO> list = dao.test2List();
		list = dao.test2GenderCheck(tGender);
		
		request.setAttribute("list", list);
		
	}
	
}