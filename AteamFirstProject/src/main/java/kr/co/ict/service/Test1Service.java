package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Test1Service {
	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
