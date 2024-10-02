package vn.web.services.impl;

import java.util.List;

import vn.web.models.CategoryModel;
import vn.web.services.ICategoryService;
import vn.web.dao.ICategoryDao;
import vn.web.dao.impl.CategoryDaoImpl;
public class CategoryServiceImpl implements ICategoryService {
	public ICategoryDao cateDao = new CategoryDaoImpl();
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findByID(int id) {
		// TODO Auto-generated method stub
		return cateDao.findByID(id);
	}

	@Override
	public void insert(CategoryModel category) {
		// TODO Auto-generated method stub
		cateDao.insert(category);
	}

	@Override
	public void update(CategoryModel category) {
		// TODO Auto-generated method stub
		cateDao.update(category);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cateDao.delete(id);
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		// TODO Auto-generated method stub
		return cateDao.findName(keyword);
	}

	@Override
	public void softDelete(CategoryModel category) {
		// TODO Auto-generated method stub
		cateDao.softDelete(category);
	}

}
