package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.StoreInfoDAO;
import kr.co.ict.domain.StoreInfoVO;

public class StoreinfoInsertService implements IStoreinfoService {
	
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	StoreInfoDAO dao = StoreInfoDAO.getInstance();
	
	String storeName =request.getParameter("storeName");
	String storeContent =request.getParameter("storeContent");
	String storeStartTime = request.getParameter("storeStartTime");
	String storeEndTime = request.getParameter("storeEndTime");
	
	System.out.println(storeStartTime + " ~ " + storeEndTime);
	String totalTime = (storeStartTime + " ~ " + storeEndTime);
	
	String storeAdd = request.getParameter("storeAdd");
	String storePhone = request.getParameter("storePhone");
	String menu = request.getParameter("menu");	
	// int storeHit = Integer.parseInt(request.getParameter("storeHit"));
	
	
	dao.storeinfoInsert(storeName, storeContent, totalTime, storeAdd, storePhone, menu);
		

	}
}
