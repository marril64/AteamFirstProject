package kr.co.ict.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import kr.co.ict.domain.Test3DAO;
import kr.co.ict.domain.Test3VO;

public class Test3DeleteService implements Test3Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		ArrayList<Integer> tNum = new ArrayList<Integer>();
		String[] value = request.getParameterValues("tNum");
		Test3DAO dao = Test3DAO.getInstance();
		
		if (value == null) {
			List<Test3VO> list = dao.test3List();
			request.setAttribute("list", list);
		} else {
			for (String val : value) {
				tNum.add(Integer.parseInt(val));
			}
			dao.test3Delete(tNum);
			List<Test3VO> list = dao.test3List();
			request.setAttribute("list", list);
		}
	}
	
}