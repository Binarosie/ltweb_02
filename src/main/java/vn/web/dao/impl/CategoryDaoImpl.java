package vn.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import vn.web.configs.DBConnectMySQL;
import vn.web.dao.ICategoryDao;
import vn.web.models.CategoryModel;
import vn.web.models.UserModel;

public class CategoryDaoImpl extends DBConnectMySQL implements ICategoryDao {
//	public Connection conn = null;
//	public PreparedStatement ps = null;
//	public ResultSet rs = null;
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from category";
		List<CategoryModel> list = new ArrayList<>();
		try {
			Connection conn = super.getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
				
			}
			//return list;
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CategoryModel findByID(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from category where categoryid = ?";
		CategoryModel category = new CategoryModel();
		try {
			Connection conn = super.getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				
				return category;
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public void insert(CategoryModel category) {
		// TODO Auto-generated method stub
		String sql = "insert into category(categoryname, images,status) \r\n"
				+ " values (?,?,?) ";
		
		try {
			Connection conn = super.getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3,category.getStatus());
			ps.executeUpdate();
			conn.close();
			ps.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void update(CategoryModel category) {
		// TODO Auto-generated method stub
		String sql = "update category set categoryname=?, images=?, status=? \r\n"
				+ " where categoryid=? ";
		
		try {
			Connection conn = super.getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,category.getCategoryname());
			ps.setString(2, category.getImages());
			ps.setInt(3,category.getStatus());
			ps.setInt(4, category.getCategoryid());
			ps.executeUpdate();
			conn.close();
			ps.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql = "dalete from category \r\n"
				+ " where categoryid=? ";
		try {
			Connection conn = super.getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
			conn.close();
			ps.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CategoryModel> findName(String keyword) {
		// TODO Auto-generated method stub
		String sql = "select * from category where categoryname like ?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			Connection conn = super.getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+keyword+"%");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImages(rs.getString("images"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
				return list;
			}
			conn.close();
			ps.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void softDelete(CategoryModel category) {
		// TODO Auto-generated method stub
		String sql = "update category set status=? \r\n"
				+ " where categoryid=? ";
		
		try {
			Connection conn = super.getDatabaseConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,category.getStatus() == 1 ? 0 : 1);
			ps.setInt(2, category.getCategoryid());
			ps.executeUpdate();
			conn.close();
			ps.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
