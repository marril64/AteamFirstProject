package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.ProjectUserDAO;
import kr.co.ict.domain.ProjectUserVO;

public class UserLoginService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		ProjectUserDAO dao = ProjectUserDAO.getInstance();
		
		if (dao.passwordCheck(id, pw)) {
			ProjectUserVO user = dao.getUserInfo(id);
			System.out.println("로그인 되었습니다. 세션을 발급합니다.");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			request.setAttribute("a", "/firstProject/userInfo.jsp");
		} else {
			System.out.println("없는 아이디이거나 비밀번호가 잘못되었습니다.");
			request.setAttribute("a", "/firstProject/userLoginFail.jsp");
		}
		
	}
	
}
