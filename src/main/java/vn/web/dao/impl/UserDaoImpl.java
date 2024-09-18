package vn.web.dao.impl;

import vn.web.configs.DBConnectMySQL;
import vn.web.dao.IUserDao;
import vn.web.models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement preparedStatement = null;
	public ResultSet resultSet = null;

	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";
		List<UserModel> users = new ArrayList<>();
		try {
			conn = super.getDatabaseConnection();
			preparedStatement = conn.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserModel user = new UserModel();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setFullname(resultSet.getString("fullname"));
				user.setImages(resultSet.getString("images"));
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id=?";
		// UserModel users = new UserModel();
		try {
			conn = super.getDatabaseConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserModel user = new UserModel();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setEmail(resultSet.getString("email"));
				user.setFullname(resultSet.getString("fullname"));
				user.setImages(resultSet.getString("images"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users(username, email, fullname, images, password) VALUES (?,?,?,?,?)";
		// UserModel users = new UserModel ();
		try {
			conn = super.getDatabaseConnection();
			preparedStatement = conn.prepareStatement(sql);
			// preparedStatement.setInt(1,user.getId());
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getFullname());
			preparedStatement.setString(4, user.getImages());
			preparedStatement.setString(5, user.getPassword());

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(UserModel user) {
		// TODO Auto-generated method stub

	}

	public UserModel get(String username) {
		String sql = "SELECT * FROM users WHERE username = ? ";
		try {
			conn = super.getDatabaseConnection();
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				UserModel user = new UserModel();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				user.setImages(resultSet.getString("images"));
				user.setFullname(resultSet.getString("fullname"));
				user.setEmail(resultSet.getString("email"));
				user.setRoleid(Integer.parseInt(resultSet.getString("roleid")));
				user.setPhone(resultSet.getString("phone"));
				user.setCreateDate(resultSet.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


//	public boolean login(String username, String password) {
//		String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
//		try {
//			UserDaoImpl usersDao = new UserDaoImpl();
//			boolean user = usersDao.findByUserName(username);
//			if (user == false) {
//				throw new Exception("User not found.");
//			} else if (username != null && password != null) {
//				conn = super.getDatabaseConnection();
//				preparedStatement = conn.prepareStatement(sql);
//				preparedStatement.setString(1, username);
//				preparedStatement.setString(2, password);
//				resultSet = preparedStatement.executeQuery();
//				if (resultSet.next()) {
//					return true;
//				}
//			} else if (username == null || password == null) {
//				throw new Exception("Username or password is null.");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

	public static void main(String[] args) {
		UserDaoImpl usersDao = new UserDaoImpl();
//        usersDao.insert(new UserModel("Thao","@","10","4","5"));
//        usersDao.insert(new UserModel("Thu","@","11","12","13"));
//        usersDao.insert(new UserModel("Thuy","@","14","15","16"));

//        List<UserModel> users = usersDao.findAll();
//        
//        for (UserModel user : users) {
//            System.out.println(user);
//        }

		// UserModel user = usersDao.findById(1);
		// System.out.println(user);

//		UserDaoImpl checkLogin = new UserDaoImpl();
//		System.out.println(checkLogin.login("Thao", "10"));
	//}
//        UserModel user = usersDao.get("quynh");
//        System.out.println(user);
}

	//@Override
//	public UserModel findByUserName(String username) {
//		String sql = "SELECT * FROM users WHERE username = ? ";
//		// UserModel user = new UserModel();
//		try {
//			conn = super.getDatabaseConnection();
//			preparedStatement = conn.prepareStatement(sql);
//			resultSet = preparedStatement.executeQuery();
//			preparedStatement.setString(1, username);
//			while (resultSet.next()) {
//				UserModel user = new UserModel();
//				user.setId(resultSet.getInt("id"));
//				user.setUsername(resultSet.getString("username"));
//				user.setPassword(resultSet.getString("password"));
//				user.setFullname(resultSet.getString("fullname"));
//				user.setImages(resultSet.getString("images"));
//				user.setEmail(resultSet.getString("email"));
//				user.setRoleid(Integer.parseInt(resultSet.getString("roleid")));
//				return user;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//		return null;
//	}

}
