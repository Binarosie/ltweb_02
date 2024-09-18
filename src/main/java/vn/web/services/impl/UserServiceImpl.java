package vn.web.services.impl;

import vn.web.configs.DBConnectMySQL;
import vn.web.dao.IUserDao;
import vn.web.dao.impl.UserDaoImpl;
import vn.web.models.UserModel;
import vn.web.services.IUserService;

public class UserServiceImpl implements IUserService {
	IUserDao userDao = new UserDaoImpl();
	public UserModel login(String username, String password) {
		UserModel user = this.get(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}
// cai nay co doi lai so voi cose cua thay
	public UserModel get(String username) {
		return userDao.get(username);
	}
	public static void main(String[] args) {
       UserServiceImpl users = new UserServiceImpl();
       if (users.get("quynh") != null) {
    	   System.out.println("valid");
       }
    }
}
