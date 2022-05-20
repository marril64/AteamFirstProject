package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.StoreInfoDAO;

public class StoreinfoDeleteService implements IStoreinfoService{ {


	}

@Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	String id = request.getParameter("id");
	// boardDetail.jsp의 삭제버튼을 눌렀을때 board_writer도 같이 히든으로 보내므로
	// board_writer를 받아서 비교할 수 있습니다.
	// 아이디가 일치하는경우만 아래의 delete로직이 호출되도록 조건문으로 감싸주세요.
	
	String storeinfo = request.getParameter("storeNum");
	System.out.println("id : " + id);

	System.out.println("storeinfo : " + storeinfo);
	if(id != null && id.equals("Admin")) {
		StoreInfoDAO dao = StoreInfoDAO.getInstance();
		String strStoreNum = request.getParameter("storeNum");
		int storeNum = Integer.parseInt(strStoreNum);
		
		
		// delete로직 호출
		dao.storeinfoDelete(storeNum);
	}
}

}
