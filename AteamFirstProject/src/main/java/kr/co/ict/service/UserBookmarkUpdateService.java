package kr.co.ict.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ProjectUserDAO;
import kr.co.ict.domain.StoreInfoVO;

public class UserBookmarkUpdateService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		ProjectUserDAO dao = ProjectUserDAO.getInstance();

		String yes = request.getParameter("yes");
		String no = request.getParameter("no");
		int userNum = Integer.parseInt(request.getParameter("userNum"));
		int storeNum = Integer.parseInt(request.getParameter("storeNum"));

		if (yes != null) {
			if (dao.bookmarkUpdate(userNum, storeNum)) {
				List<StoreInfoVO> store = dao.getUserBookmark(userNum);
				request.setAttribute("store", store);
				request.setAttribute("f", "/firstProject/userBookmark.jsp");
			} else {
				request.setAttribute("storeNum", storeNum);
				request.setAttribute("f", "/firstProject/userBookmarkFail.jsp");
			}
			
		} else if (no != null) {
			request.setAttribute("storeNum", storeNum);
			request.setAttribute("f", "/AteamFirstProject/getStoreInfoDetail.do");
		}
		
	}
	
}
