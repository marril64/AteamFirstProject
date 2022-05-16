package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.ServerPreparedQueryTestcaseGenerator;

public interface IStoreinfoService {
	// 서블릿 내부 메서드와 마찬가지로 request, response를 사용할 수 있도록 메서드 정의
	void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
}
