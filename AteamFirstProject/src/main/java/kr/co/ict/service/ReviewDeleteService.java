package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ProjectUserDAO;
import kr.co.ict.domain.ReviewrDAO;
import kr.co.ict.domain.StoreInfoDAO;

public class ReviewDeleteService implements lReviewrservice {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		ReviewrDAO dao = ReviewrDAO.getInstance();
		ProjectUserDAO dao2 = ProjectUserDAO.getInstance();
		int reviewNum = Integer.parseInt(request.getParameter("reviewNum"));
	
		if(id != null && id.equals("Admin")) {
			dao.reviewDelete(reviewNum);
		}
		
	}

}
