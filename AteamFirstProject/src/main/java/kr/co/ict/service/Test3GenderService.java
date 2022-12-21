package kr.co.ict.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.Test3DAO;
import kr.co.ict.domain.Test3VO;

public class Test3GenderService implements Test3Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tGender = request.getParameter("tGender");
		
		request.setCharacterEncoding("utf-8");
		Test3DAO dao = Test3DAO.getInstance();
		List<Test3VO> list = dao.test3List();
		list = dao.test3GenderCheck(tGender);
		
		request.setAttribute("list", list);
		
	}
	
}