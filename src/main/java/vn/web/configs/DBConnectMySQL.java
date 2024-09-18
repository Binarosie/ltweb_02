package vn.web.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL {
	private static Connection con = null;
	private static String USERNAME = "root";
	private static String PASSWORD = "123456789";
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/ltweb01";

	public static Connection getDatabaseConnection() throws SQLException, Exception {
		try {
			Class.forName(DRIVER);
			return con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		try (Connection conn = getDatabaseConnection()) {
			if (conn != null) {
				System.out.println("Successfully connected to the database.");
			} else {
				System.out.println("Connection failed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
