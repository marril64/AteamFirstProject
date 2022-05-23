package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ProjectUserDAO;

public class UserJoinService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		int phone = Integer.parseInt(request.getParameter("phone"));
		
		ProjectUserDAO dao = ProjectUserDAO.getInstance();
		
		if (dao.userJoinCheck(id, pw, phone, nick)) {
			System.out.println("가입되었습니다.");
			request.setAttribute("b", "/firstProject/userJoinSuccess.jsp");
		} else {
			System.out.println("아이디나 닉네임이 중복되었습니다.");
			request.setAttribute("b", "/firstProject/userJoinFail.jsp");
		}
		
	}
	
}
