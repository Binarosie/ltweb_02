package vn.web.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.web.models.CategoryModel;
import vn.web.services.ICategoryService;
import vn.web.services.impl.CategoryServiceImpl;
import vn.web.utilities.Constant;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = { "/admin/category",
		"/admin/category/edit", 
		"/admin/category/update", 
		"/admin/category/add",
		"/admin/category/insert" })
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ICategoryService cateService = new CategoryServiceImpl();

	// Constants for request attributes
	private static final String ATTR_LIST_CATEGORIES = "listcate";
	private static final String ATTR_CATEGORY = "cate";

	// Constants for parameter names
	private static final String PARAM_CATEGORY_NAME = "categoryname";
	private static final String PARAM_STATUS = "status";
	private static final String PARAM_CATEGORY_ID = "categoryid";
	private static final String PARAM_IMAGE = "images";

	// Constant for the upload directory
	private static final String UPLOAD_DIRECTORY = Constant.UPLOAD_DIRECTORY;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();

		if (url.contains(Constant.URL_CATEGORIES)) {
			List<CategoryModel> categories = cateService.findAll();
			req.setAttribute(ATTR_LIST_CATEGORIES, categories);
			req.getRequestDispatcher(Constant.VIEW_CATEGORY_LIST).forward(req, resp);
		} else if (url.contains(Constant.URL_CATEGORY_ADD)) {
			req.getRequestDispatcher(Constant.VIEW_CATEGORY_ADD).forward(req, resp);
		} else if (url.contains(Constant.URL_CATEGORY_EDIT)) {
			CategoryModel category = cateService.findByID(Integer.parseInt(req.getParameter("id")));
			req.setAttribute(ATTR_CATEGORY, category);
			req.getRequestDispatcher(Constant.VIEW_CATEGORY_EDIT).forward(req, resp);
		} else if (url.contains(Constant.URL_CATEGORY_DELETE)) {
			int id = Integer.parseInt(req.getParameter("id"));
			cateService.delete(id);
			resp.sendRedirect(req.getContextPath() + Constant.URL_CATEGORIES);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();

		if (url.contains(Constant.URL_CATEGORY_INSERT)) {
			handleInsert(req, resp);
		} else if (url.contains(Constant.URL_CATEGORY_UPDATE)) {
			handleUpdate(req, resp);
		}
	}

	private void handleInsert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryModel category = new CategoryModel();
		category.setCategoryname(req.getParameter(PARAM_CATEGORY_NAME));
		category.setStatus(Integer.parseInt(req.getParameter(PARAM_STATUS)));

		String imageName = handleImageUpload(req, null);
		category.setImages(imageName);

		cateService.insert(category);
		resp.sendRedirect(req.getContextPath() + Constant.URL_CATEGORIES);
	}

	private void handleUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int categoryId = Integer.parseInt(req.getParameter(PARAM_CATEGORY_ID));
		CategoryModel currentCategory = cateService.findByID(categoryId);

		CategoryModel category = new CategoryModel();
		category.setCategoryid(categoryId);
		category.setCategoryname(req.getParameter(PARAM_CATEGORY_NAME));
		category.setStatus(Integer.parseInt(req.getParameter(PARAM_STATUS)));

		String imageName = handleImageUpload(req, currentCategory.getImages());
		category.setImages(imageName);

		cateService.update(category);
		resp.sendRedirect(req.getContextPath() + Constant.URL_CATEGORIES);
	}

	private String handleImageUpload(HttpServletRequest req, String currentImage) throws IOException, ServletException {
		File uploadDir = new File(UPLOAD_DIRECTORY);

		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		Part part = req.getPart(PARAM_IMAGE);
		if (part != null && part.getSize() > 0) {
			String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			String ext = filename.substring(filename.lastIndexOf(".") + 1);
			String newFileName = System.currentTimeMillis() + "." + ext;
			part.write(UPLOAD_DIRECTORY + "/" + newFileName);
			return newFileName;
		}

		return currentImage; // Keep the current image if no new image is uploaded
	}

}
