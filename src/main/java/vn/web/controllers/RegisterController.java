package vn.web.controllers;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.web.models.UserModel;
import vn.web.services.impl.UserServiceImpl;
import vn.web.utilities.Constant;
import vn.web.utilities.Email;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute(Constant.SESSION_USERNAME) != null) {
			resp.sendRedirect(req.getContextPath() + "/admin");
			return;
		}

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.print(cookie.getValue());
				if (cookie.getName().equals(Constant.COOKIE_REMEMBER)) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/admin");
					return;
				}
			}
		}
		req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
	}

//	@SuppressWarnings("static-access")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fullName = req.getParameter("fullName");
//		String images = req.getParameter("images");
//		String phone = req.getParameter("phone");

		UserServiceImpl service = new UserServiceImpl();
		String alertMsg = "";

		if (service.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại!";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}

		if (service.checkExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			return;
		}
		
		Email mail = new Email();
		String code = mail.getRandom();
		UserModel user = new UserModel(username, fullName,  email, code);
		boolean check = mail.sendEmailToActive(user);

		if (check) {
			HttpSession session = req.getSession();
			session.setAttribute("account", user);

			boolean isSuccess = service.register(username, password, fullName, email, code);
			if (isSuccess) {
				resp.sendRedirect(req.getContextPath() + "/verifyCode");
			} else {
				alertMsg = "System error!";
				req.setAttribute("error", alertMsg);
				req.getRequestDispatcher(Constant.REGISTER).forward(req, resp);
			}
		} else {
			PrintWriter out = resp.getWriter();
			out.println("Lỗi gửi mail");
		}

	}

}
