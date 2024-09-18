package vn.web.services;

import vn.web.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	UserModel get(String username);
}
