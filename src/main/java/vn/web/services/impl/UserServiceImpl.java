package vn.web.services.impl;


import vn.web.services.impl.UserServiceImpl;
import vn.web.configs.DBConnectMySQL;
import vn.web.dao.IUserDao;
import vn.web.dao.impl.UserDaoImpl;
import vn.web.models.UserModel;
import vn.web.services.IUserService;

public class UserServiceImpl implements IUserService {
	
	// get all methods from UserDAO
	IUserDao userDAO = new UserDaoImpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUserName(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUserName(String username) {
		return userDAO.findByUsername(username);
	}
	
	@Override
	public UserModel findOne(String username) {
		return userDAO.findOne(username);
	}

	@Override
	public void insert(UserModel user) {
		userDAO.insert(user);
		
	}

	@Override
	public boolean register(String username, String password, String fullName, String email, String images, String phone) {
	    
		if (this.checkExistUsername(username)) {
	        return false;
	    }
		
		if (this.checkExistEmail(email)) {
			return false;
		}
		
		if (this.checkExistPhone(phone)) {
			return false;
		}

	    // Get the current date
	    java.sql.Date date = new java.sql.Date(System.currentTimeMillis());

	  
	    userDAO.insert(new UserModel(username, password, fullName, email, images, 3, phone, date));

	    return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDAO.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDAO.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDAO.checkExistPhone(phone);
	}
	
	@Override
	public boolean updatePassword(String username, String newPassword) {
		return userDAO.updatePassword(username, newPassword);
	}
	

	@Override
	public boolean register(String username, String password, String fullName, String email, String code) {
		if (this.checkExistUsername(username)) {
	        return false;
	    }
		
		if (this.checkExistEmail(email)) {
			return false;
		}
	  
	    userDAO.insertRegister(new UserModel(username, password, fullName, email, 3, 0, code));

	    return true;
	}

	@Override
	public void updateStatus(UserModel user) {
		userDAO.updateStatus(user);
	}
	
	@Override
	public boolean update(UserModel user) {
		return userDAO.update(user);
	}
	
	public static void main(String[] args) {
//	    UserServiceImpl userService = new UserServiceImpl();
//
//	    UserModel user = userService.findOne("userK");
//	    
//	    user.setFullName("Nguyễn Thị A");
//	    
//	    
//	    boolean check = userService.update(user);
//	    if (check) {
//	        System.out.println("Successfully!");
//	    } else {
//	        System.out.println("Failed.");
//	    }

	}

}