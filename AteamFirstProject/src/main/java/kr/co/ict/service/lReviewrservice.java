package kr.co.ict.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public interface lReviewrservice {
	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
