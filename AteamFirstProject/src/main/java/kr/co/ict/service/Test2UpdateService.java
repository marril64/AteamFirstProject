package kr.co.ict.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.Test2DAO;
import kr.co.ict.domain.Test2VO;

public class Test2UpdateService implements Test2Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		Test2DAO dao = Test2DAO.getInstance();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		System.out.println(request.getParameter("tNum"));
		
		String tId = request.getParameter("tId");
		String tName = request.getParameter("tName");
		String tGender = request.getParameter("tGender");
		String tCountry = request.getParameter("tCountry");
		String tCity = request.getParameter("tCity");
		
		ArrayList<String> rId = new ArrayList<>();
		ArrayList<String> rName = new ArrayList<>();
		ArrayList<String> rGender = new ArrayList<>();
		ArrayList<String> rCountry = new ArrayList<>();
		ArrayList<String> rCity = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) {
			
			if (request.getParameter("rId" + Integer.toString(i)) != null) {
				rId.add(request.getParameter("rId" + Integer.toString(i)));
				rName.add(request.getParameter("rName" + Integer.toString(i)));
				rGender.add(request.getParameter("rGender" + Integer.toString(i)));
				rCountry.add(request.getParameter("rCountry" + Integer.toString(i)));
				rCity.add(request.getParameter("rCity" + Integer.toString(i)));
			} else {
				break;
			}
			
			if (dao.test2Join(rId.get(i - 1), rName.get(i - 1), rGender.get(i - 1), rCountry.get(i - 1), rCity.get(i - 1))) {
		        out.write("<script>alert('" + "가입이 승인되었습니다." + "');location.href='" + "http://localhost:8181/AteamFirstProject/firstProject/test2.test2" + "';</script>");
		        out.flush();
		        out.close();
			} else {
		        out.write("<script>alert('" + rId.get(i - 1) + "는 중복된 아이디입니다." + "');location.href='" + "http://localhost:8181/AteamFirstProject/firstProject/test2.test2" + "';</script>");
		        out.flush();
		        out.close();
			}
		}
		
		
		if (request.getParameter("tNum") != null) {
			int tNum = Integer.parseInt(request.getParameter("tNum"));
			if (dao.test2Update(tNum, tId, tName, tGender, tCountry, tCity)) {
		        out.write("<script>alert('" + "회원정보가 수정되었습니다." + "'); window.close(); </script>");
		        out.flush();
		        out.close();
			} else {
		        out.write("<script>alert('" + "중복된 아이디입니다." + "'); window.close(); </script>");
		        out.flush();
		        out.close();
			}
		}
		
		List<Test2VO> list = dao.test2List();
		request.setAttribute("list", list);
		
	}
	
}