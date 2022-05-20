package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.StoreInfoDAO;
import kr.co.ict.domain.StoreInfoVO;

public class StoreinfoUpdateFormService implements IStoreinfoService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StoreInfoDAO dao = StoreInfoDAO.getInstance();
		String strstoreNum = request.getParameter("storeNum");
		
		int storeNum = Integer.parseInt(strstoreNum);		
		StoreInfoVO storeinfo = dao.getstoreinfoDetail(storeNum);
		request.setAttribute("storeinfo", storeinfo);
	}

}
