package vn.web.controllers;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.web.models.UserModel;
import vn.web.services.impl.UserServiceImpl;


@WebServlet(urlPatterns = "/forgotPassword")
public class ForgotPassword extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	UserServiceImpl service = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String newPassword = req.getParameter("password");
		String email = req.getParameter("email");
		
		UserModel user = service.findOne(username);
		boolean check = false;
		if (!service.checkExistUsername(username) || user == null || !service.checkExistEmail(email)) {
			req.setAttribute("error", "Tài khoản không tồn tại!");
			req.getRequestDispatcher("/JDBC/forgotPassword").forward(req, resp);
		} else {
			check = service.updatePassword(username, newPassword);
			if(check) {
				req.setAttribute("alert", "Đổi mật khẩu thành công! Vui lòng đăng nhập lại.");
				req.getRequestDispatcher("/views/login.jsp").forward(req, resp); // Redirect to login
			} else {
				req.setAttribute("error", "Có lỗi xảy ra. Xin vui lòng thử lại!");
				req.getRequestDispatcher("/forgotPassword").forward(req, resp);
			}
		}
	}

}
