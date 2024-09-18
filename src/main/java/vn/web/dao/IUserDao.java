package vn.web.dao;
import java.util.List;

import vn.web.models.UserModel;

public interface IUserDao {
	
	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
	
	void update (UserModel user);
	
	//UserModel findByUserName(String username);
	
	UserModel get(String username);
	
	//boolean login(String username, String password);
	
}
