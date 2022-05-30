package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ReviewrDAO;
import kr.co.ict.domain.ReviewrVO;
import kr.co.ict.domain.StoreInfoDAO;
import kr.co.ict.domain.StoreInfoVO;

public class ReviewDetailService implements lReviewrservice {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewrDAO dao = ReviewrDAO.getInstance();
		int reviewNum = Integer.parseInt(request.getParameter("reviewNum"));
		dao.upHit(reviewNum);
		ReviewrVO review = dao.getreviewrDetail(reviewNum);
		request.setAttribute("review", review);
	}

}
