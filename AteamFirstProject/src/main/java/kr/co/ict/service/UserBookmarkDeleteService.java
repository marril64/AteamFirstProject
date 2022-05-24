package kr.co.ict.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ProjectUserDAO;
import kr.co.ict.domain.StoreInfoVO;

public class UserBookmarkDeleteService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		ProjectUserDAO dao = ProjectUserDAO.getInstance();

		String yes = request.getParameter("yes");
		String no = request.getParameter("no");
		int userNum = Integer.parseInt(request.getParameter("userNum"));
		
		if (yes != null) {
			int storeNum = Integer.parseInt(request.getParameter("storeNum"));
			dao.bookmarkDelete(userNum, storeNum);
			List<StoreInfoVO> store = dao.getUserBookmark(userNum);
			request.setAttribute("store", store);
		} else if (no != null) {
			List<StoreInfoVO> store = dao.getUserBookmark(userNum);
			request.setAttribute("store", store);
		}
		
	}
	
}
