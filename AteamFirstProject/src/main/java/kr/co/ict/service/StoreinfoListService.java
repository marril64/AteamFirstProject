package kr.co.ict.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.StoreInfoDAO;
import kr.co.ict.domain.StoreInfoVO;
import kr.co.ict.domain.StoreinfoButtonDTO;

public class StoreinfoListService implements IStoreinfoService  {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		System.out.println("로그인 아이디 : " + id);

		String strpageNum = request.getParameter("pageNum");
		int pageNum = 1;
		System.out.println("페이지 번호 : " + strpageNum);
		if(strpageNum != null) {
			 pageNum = Integer.parseInt(strpageNum);
		}
		
			
		
		// DAO는 다시 생성해줘야 합니다.
		StoreInfoDAO dao = StoreInfoDAO.getInstance();
		
		int storeinfoCount = dao.getStoreCount();// 글 갯수를 얻어오기.
		StoreinfoButtonDTO buttons = new StoreinfoButtonDTO(storeinfoCount, pageNum); // 밑에 깔아줘야 하는 버튼에 대한 정보 추가
		
		// 바인딩해서 넘겨주신 다음, 결과페이지에서 수치정보도 확인해주세요. 
		request.setAttribute("buttons", buttons);
		
		List<StoreInfoVO> storeinfoList = dao.getstoreinfoList(pageNum);
		request.setAttribute("storeinfoList", storeinfoList);
	}

}
