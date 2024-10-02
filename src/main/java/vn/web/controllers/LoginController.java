package vn.web.controllers;
import java.io.IOException;

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

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {

	UserServiceImpl service = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            resp.sendRedirect(req.getContextPath() + "/home");
            return;

        }
        // Check cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/home");
                    return;
                }
            }
        }
        req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean isRememberMe = false;
		String remember = req.getParameter("remember");

		if ("on".equals(remember)) {
			isRememberMe = true;
		}

		if (username.isEmpty() || password.isEmpty()) {
			req.setAttribute("error", "Tài khoản hoặc mật khẩu không được rỗng");  
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		
		UserModel user = service.login(username, password);  
		if (user != null) {
			
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);

			if (isRememberMe) {
				saveRememberMe(resp, username);
			}

			
			req.setAttribute("alert", "Đăng nhập thành công!");
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			
			req.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
	}

	private void saveRememberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
//		cookie.setMaxAge(30 * 60);  
		cookie.setMaxAge(0);  
		cookie.setHttpOnly(true);   
		cookie.setSecure(true);     
		response.addCookie(cookie);
	}
}
