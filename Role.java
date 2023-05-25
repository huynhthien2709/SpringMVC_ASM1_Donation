package com.asm1.entity;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@Column(name = "id")
	private int id;
	
	@NotNull(message = "is required")
	@Column(name = "role_name")
	private String roleName;
	
	@OneToMany(mappedBy = "role")
	private List<User> users;
	

	public Role() {
	}

	public Role(int id, @NotNull(message = "is required") String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}

	


	
	
	
}
