package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.StoreInfoDAO;

public class StoreInfoUpdateService implements IStoreinfoService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		StoreInfoDAO dao = StoreInfoDAO.getInstance();
		String strStoreNum = request.getParameter("storeNum");		
		int Storenum = Integer.parseInt(strStoreNum);
		String id = request.getParameter("id");

		
		String storeName =request.getParameter("storeName");
		String storeContent =request.getParameter("storeContent");
		String storeStartTime =request.getParameter("storeStartTime");
		String storeEndTime =request.getParameter("storeEndTime");
		String storeAdd = request.getParameter("storeAdd");
		String storePhone = request.getParameter("storePhone");
		String menu = request.getParameter("menu");	
		String time = storeStartTime + storeEndTime;

		System.out.println("업데이트중");
		if(id != null && id.equals("Admin")) {
		
			dao.StoreInfoUpdate(storeName, storeContent, storeAdd, time, storePhone, menu, Storenum);
		}

		}


		
	}
	
