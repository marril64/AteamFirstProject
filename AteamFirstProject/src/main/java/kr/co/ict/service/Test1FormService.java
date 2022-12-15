package kr.co.ict.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.Test1DAO;
import kr.co.ict.domain.Test1VO;

public class Test1FormService implements Test1Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		Test1DAO dao = Test1DAO.getInstance();
		
	}
	
}