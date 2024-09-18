package vn.web.models;

public class RoleModel {
	private String roleid;
	private String roleName;
	
	public RoleModel(String roleid, String roleName) {
		super();
		this.roleid = roleid;
		this.roleName = roleName;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public RoleModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RoleModel [roleid=" + roleid + ", roleName=" + roleName + "]";
	}
	
	
}
