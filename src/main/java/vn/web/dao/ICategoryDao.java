package vn.web.dao;

import java.util.List;

import vn.web.models.CategoryModel;

public interface ICategoryDao {
	List <CategoryModel> findAll();
	CategoryModel findByID(int id);
	void insert (CategoryModel category);
	void update (CategoryModel category);
	void delete (int id);
	List<CategoryModel> findName(String keyword);
	void softDelete (CategoryModel category);
}
