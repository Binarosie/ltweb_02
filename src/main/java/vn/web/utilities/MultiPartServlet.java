package vn.web.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import vn.web.models.UserModel;
import vn.web.services.impl.UserServiceImpl;

@WebServlet(name = "MultiPartServlet", urlPatterns = { "/multiPartServlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class MultiPartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String getFileName(Part part) {
		
		
		for (String content : part.getHeader("content-disposition").split(";")) {

			if (content.trim().startsWith("filename"))

				return content.substring(content.indexOf("=") + 2, content.length() - 1);
			
		}

		return Constant.DEFAULT_FILENAME;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fullName = req.getParameter("fullName");
		String phone = req.getParameter("phone");
		
		String uploadPath = File.separator + Constant.UPLOAD_DIRECTORY; // upload vào thư mục bất kỳ
		// String uploadPath = getServletContext().getRealPath("") + File.separator +
		// UPLOAD_DIRECTORY; //upload vào thư mục project

		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		try {
			String fileName = "";
			
			for (Part part : req.getParts()) {
			    if (part.getName().equals("multiPartServlet") && part.getSize() > 0) {  // Assuming the file input is named "multiPartServlet"
			        fileName = getFileName(part);
			        part.write(uploadPath + File.separator + fileName);
			    }
			}

			
			HttpSession session = req.getSession(false);
			UserModel user = (UserModel) session.getAttribute(Constant.SESSION_ACCOUNT);
			
			boolean check = false;
			

			if(user != null) {
				user.setFullName(fullName);
				user.setPhone(phone);
				user.setImages(fileName);
				UserServiceImpl service = new UserServiceImpl();
				check = service.update(user);
			}
			
			if(check) {
				req.setAttribute("message", "Uploading successfully!");
			} else {
				req.setAttribute("message", "Uploading failed!");
			}

		} catch (FileNotFoundException fne) {

			req.setAttribute("message", "There was an error: " + fne.getMessage());

		}

		getServletContext().getRequestDispatcher("/views/result.jsp").forward(req, resp);

	}
}