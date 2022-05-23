package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.ProjectUserDAO;
import kr.co.ict.domain.ProjectUserVO;

public class UserLogoutService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String yes = request.getParameter("yes");
		String no = request.getParameter("no");
		
		if (yes != null) {
			HttpSession session = request.getSession();
			System.out.println("로그아웃으로 인해 세션을 파기합니다.");
			session.invalidate();
		} else if (no != null) {
			System.out.println("로그아웃하지 않습니다. 세션을 유지합니다.");
		}
		
	}
	
}
