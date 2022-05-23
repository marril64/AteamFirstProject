package kr.co.ict.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ProjectUserDAO;
import kr.co.ict.domain.StoreInfoVO;

public class UserBookmarkFormService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		ProjectUserDAO dao = ProjectUserDAO.getInstance();
		
		int userNum = Integer.parseInt(request.getParameter("userNum"));
		
		List<StoreInfoVO> store = dao.getUserBookmark(userNum);
		
		System.out.println(store);
		request.setAttribute("store", store);
		
	}
	
}
