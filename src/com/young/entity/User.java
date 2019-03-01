package com.young.entity;

/**
 * @author Young
 * @version1.0
 */
public class User {
	private int u_id;
	private String u_name;
	private String u_pwd;
	private String u_type;

	public User(int u_id, String u_pwd) {
		this.u_id = u_id;
		this.u_pwd = u_pwd;
	}

	public User(int u_id, String u_name, String u_type) {
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_type = u_type;
	}

	public User(String u_type) {
		this.u_type = u_type;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}

	public String getU_type() {
		return u_type;
	}

	public void setU_type(String u_type) {
		this.u_type = u_type;
	}
}
