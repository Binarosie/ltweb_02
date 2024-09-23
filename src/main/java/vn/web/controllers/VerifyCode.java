package vn.web.controllers;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.web.models.UserModel;
import vn.web.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = "/verifyCode")
public class VerifyCode extends HttpServlet {
	
	UserServiceImpl service = new UserServiceImpl();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/verify.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = resp.getWriter()) {
			HttpSession session = req.getSession();
			UserModel user = (UserModel) session.getAttribute("account");
			String code = req.getParameter("authcode");
			
			if(code.equals(user.getCode())) {
				user.setEmail(user.getEmail());
				user.setStatus(1);
				service.updateStatus(user);
				
				out.println("Success");
			} else {
				out.println("Failure");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
