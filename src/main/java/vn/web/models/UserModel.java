package vn.web.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

    private int id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private String images;
    private int roleId;
    private String phone;
    private Date createDate;
    private int status;
    private String code;

	public UserModel(int id, String username, String password, String fullName, String email, String images, int roleId,
			String phone, Date createDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.images = images;
		this.roleId = roleId;
		this.phone = phone;
		this.createDate = createDate;
	}
	
	public UserModel(String username, String password, String fullName, String email, String images, int roleId,
			String phone, Date createDate) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.images = images;
		this.roleId = roleId;
		this.phone = phone;
		this.createDate = createDate;
	}
	

	public UserModel(String username, String password, String fullName, String email, String images, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.images = images;
		this.phone = phone;
	}
	

	public UserModel(String username, String password, String fullName, String email, int roleId, int status,
			String code) {
		super();
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.roleId = roleId;
		this.status = status;
		this.code = code;
	}
	

	public UserModel(String username, String fullName, String email, String code) {
		super();
		this.username = username;
		this.fullName = fullName;
		this.email = email;
		this.code = code;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}