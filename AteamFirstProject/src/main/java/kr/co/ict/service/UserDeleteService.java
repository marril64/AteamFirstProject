package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.ProjectUserDAO;

public class UserDeleteService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		ProjectUserDAO dao = ProjectUserDAO.getInstance();
		
		if (dao.userDelete(id, pw)) {
			System.out.println("정상적으로 탈퇴되었습니다.");
			HttpSession session = request.getSession();
			session.invalidate();
			System.out.println("세션을 파기합니다.");
			request.setAttribute("c", "/firstProject/userDeleteSuccess.jsp");
		} else {
			System.out.println("아이디와 비밀번호를 다시 입력해 주십시오.");
			request.setAttribute("c", "/firstProject/userInfo.jsp");
		}
		
	}
	
}
