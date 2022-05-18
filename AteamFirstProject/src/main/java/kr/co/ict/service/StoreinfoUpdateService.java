package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.StoreInfoDAO;

public class StoreinfoUpdateService implements IStoreinfoService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StoreInfoDAO dao = StoreInfoDAO.getInstance();
		String strStoreNum = request.getParameter("storeNum");		
		int storenum = Integer.parseInt(strStoreNum);
		String id = request.getParameter("id");

		String storeNum = request.getParameter("storeNum");
		String storeName =request.getParameter("storeName");
		String storeContent =request.getParameter("storeContent");
		String storeTime =request.getParameter("storeTime");
		String storeAdd = request.getParameter("storeAdd");
		String storePhone = request.getParameter("storePhone");
		String menu = request.getParameter("menu");	
		int storeHit = Integer.parseInt(request.getParameter("storeHit"));
		
		if(id != null && id.equals("Admin")) {
		
			dao.storeinfoInsert(storeName, storeContent, storeTime, storeAdd, storePhone, menu, storeHit);
		}

		}


		
	}
	
