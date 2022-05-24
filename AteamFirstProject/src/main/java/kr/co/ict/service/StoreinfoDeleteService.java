package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.ProjectUserDAO;
import kr.co.ict.domain.StoreInfoDAO;

public class StoreinfoDeleteService implements IStoreinfoService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		StoreInfoDAO dao = StoreInfoDAO.getInstance();
		ProjectUserDAO dao2 = ProjectUserDAO.getInstance();
		int storeNum = Integer.parseInt(request.getParameter("storeNum"));
	
		if(id != null && id.equals("Admin")) {
			dao2.bookmarkAllDelete(storeNum);
			dao.storeinfoDelete(storeNum);
		}
		
	}

}
