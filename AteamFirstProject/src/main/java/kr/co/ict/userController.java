package kr.co.ict;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ProjectUserDAO;
import kr.co.ict.service.IUserService;
import kr.co.ict.service.StoreinfoListService;
import kr.co.ict.service.UserBookmarkDeleteService;
import kr.co.ict.service.UserBookmarkFormService;
import kr.co.ict.service.UserBookmarkUpdateService;
import kr.co.ict.service.UserDeleteService;
import kr.co.ict.service.UserJoinService;
import kr.co.ict.service.UserLoginService;
import kr.co.ict.service.UserLogoutService;
import kr.co.ict.service.UserPasswordCheckService;
import kr.co.ict.service.UserUpdateService;

/**
 * Servlet implementation class userController
 */
@WebServlet("*.user")
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String ui = null;
		ProjectUserDAO dao = ProjectUserDAO.getInstance();
		IUserService sv = null;
		
		if (uri.equals("/AteamFirstProject/userLoginForm.user")) {
			ui = "/firstProject/userLogin.jsp";
		} else if (uri.equals("/AteamFirstProject/userLogin.user")) {
			sv = new UserLoginService();
			sv.execute(request, response);
			ui = (String)request.getAttribute("a");
		} else if (uri.equals("/AteamFirstProject/userLogoutForm.user")) {
			ui = "/firstProject/userLogout.jsp";
		} else if (uri.equals("/AteamFirstProject/userLogout.user")) {
			sv = new UserLogoutService();
			sv.execute(request, response);
			ui = "/firstProject/userLogin.jsp";
		} else if (uri.equals("/AteamFirstProject/userJoinForm.user")) {
			ui = "/firstProject/userJoin.jsp";
		} else if (uri.equals("/AteamFirstProject/userJoin.user")) {
			sv = new UserJoinService();
			sv.execute(request, response);
			ui = (String)request.getAttribute("b");
		} else if (uri.equals("/AteamFirstProject/userDeleteForm.user")) {
			ui = "/firstProject/userDelete.jsp";
		} else if (uri.equals("/AteamFirstProject/userDelete.user")) {
			sv = new UserDeleteService();
			sv.execute(request, response);
			ui = (String)request.getAttribute("c");
		} else if (uri.equals("/AteamFirstProject/userUpdateForm.user")) {
			ui = "/firstProject/userUpdate.jsp";
		} else if (uri.equals("/AteamFirstProject/userUpdate.user")) {
			sv = new UserUpdateService();
			sv.execute(request, response);
			ui = (String)request.getAttribute("d");
		} else if (uri.equals("/AteamFirstProject/userPasswordCheckForm.user")) {
			ui = "/firstProject/userPasswordCheck.jsp";
		} else if (uri.equals("/AteamFirstProject/userPasswordCheck.user")) {
			sv = new UserPasswordCheckService();
			sv.execute(request, response);
			ui = (String)request.getAttribute("e");
		} else if (uri.equals("/AteamFirstProject/userBookmarkForm.user")) {
			sv = new UserBookmarkFormService();
			sv.execute(request, response);
			ui = "/firstProject/userBookmark.jsp";
		} else if (uri.equals("/AteamFirstProject/userBookmarkUpdate.user")) {
			sv = new UserBookmarkUpdateService();
			sv.execute(request, response);
			ui = (String)request.getAttribute("f");
		} else if (uri.equals("/AteamFirstProject/userBookmarkDelete.user")) {
			sv = new UserBookmarkDeleteService();
			sv.execute(request, response);
			ui = "/firstProject/userBookmark.jsp";
		} else if (uri.equals("/AteamFirstProject/userBookmarkDeleteForm.user")) {
			ui = "/firstProject/userBookmarkDelete.jsp";
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
	}

}
