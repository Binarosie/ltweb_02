package vn.web.services;

import vn.web.models.UserModel;

public interface IUserService {
UserModel login(String username, String password);
	
	UserModel findByUserName(String username);
	
	UserModel findOne(String username);
	
	void insert(UserModel user);
	
//	boolean register(String username, String password, String fullName, String email, 
//			String images, String phone);
	
	boolean register(String username, String password, String fullName, String email, String code);
	
	void updateStatus(UserModel user);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);
	
	boolean updatePassword(String username, String newPassword);

}
