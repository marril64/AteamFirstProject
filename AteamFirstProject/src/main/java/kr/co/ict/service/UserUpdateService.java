package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.ProjectUserDAO;
import kr.co.ict.domain.ProjectUserVO;

public class UserUpdateService implements IUserService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		ProjectUserDAO dao = ProjectUserDAO.getInstance();

		String id = request.getParameter("id");
		
		if (id != null) {
			String pw = request.getParameter("pw");
			String nick = request.getParameter("nick");
			int phone = Integer.parseInt(request.getParameter("phone"));
			
			dao.userUpdateCheck(id, pw, nick, phone);
			System.out.println("회원정보가 수정되었습니다.");
			ProjectUserVO user = dao.getUserInfo(id);
			System.out.println("회원정보 변경으로 세션을 재발급합니다.");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.setAttribute("d", "/firstProject/userUpdateSuccess.jsp");
		} else {
			System.out.println("사실상 더미데이터.");
			request.setAttribute("d", "/firstProject/userUpdateDeleteFail.jsp");
		}
		
	}

}
