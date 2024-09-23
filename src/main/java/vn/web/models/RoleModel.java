package vn.web.models;

import java.io.Serializable;

public class RoleModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int roleid;
	private String roleName;
	
	public RoleModel() { }

	public RoleModel(int roleid, String roleName) {
		super();
		this.roleid = roleid;
		this.roleName = roleName;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
