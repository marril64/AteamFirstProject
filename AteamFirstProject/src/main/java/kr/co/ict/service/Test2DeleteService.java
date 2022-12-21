package kr.co.ict.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import kr.co.ict.domain.Test2DAO;
import kr.co.ict.domain.Test2VO;

public class Test2DeleteService implements Test2Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		ArrayList<Integer> tNum = new ArrayList<Integer>();
		String[] value = request.getParameterValues("tNum");
		Test2DAO dao = Test2DAO.getInstance();
		
		if (value == null) {
			List<Test2VO> list = dao.test2List();
			request.setAttribute("list", list);
		} else {
			for (String val : value) {
				tNum.add(Integer.parseInt(val));
			}
			dao.test2Delete(tNum);
			List<Test2VO> list = dao.test2List();
			request.setAttribute("list", list);
		}
	}
	
}