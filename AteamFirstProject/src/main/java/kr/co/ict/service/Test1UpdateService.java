package kr.co.ict.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.Test1DAO;
import kr.co.ict.domain.Test1VO;

public class Test1UpdateService implements Test1Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		Test1DAO dao = Test1DAO.getInstance();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String tId = request.getParameter("tId");
		String tName = request.getParameter("tName");
		String tGender = request.getParameter("tGender");
		String tCountry = request.getParameter("tCountry");
		String tCity = request.getParameter("tCity");
		
		if (request.getParameter("tNum") == null) {
			if (dao.test1Join(tId, tName, tGender, tCountry, tCity)) {
		        out.write("<script>alert('" + "가입이 승인되었습니다." + "');location.href='" + "http://localhost:8181/AteamFirstProject/firstProject/test1.test1" + "';</script>");
		        out.flush();
		        out.close();
			} else {
		        out.write("<script>alert('" + "중복된 아이디입니다." + "');location.href='" + "http://localhost:8181/AteamFirstProject/firstProject/test1.test1" + "';</script>");
		        out.flush();
		        out.close();
			}
		} else {
			int tNum = Integer.parseInt(request.getParameter("tNum"));
			if (dao.test1Update(tNum, tId, tName, tGender, tCountry, tCity)) {
		        out.write("<script>alert('" + "회원정보가 수정되었습니다." + "');location.href='" + "http://localhost:8181/AteamFirstProject/firstProject/test1.test1" + "';</script>");
		        out.flush();
		        out.close();
			} else {
		        out.write("<script>alert('" + "중복된 아이디입니다." + "');location.href='" + "http://localhost:8181/AteamFirstProject/firstProject/test1.test1" + "';</script>");
		        out.flush();
		        out.close();
			}
		}
		
		List<Test1VO> list = dao.test1List();
		request.setAttribute("list", list);
		
	}
	
}