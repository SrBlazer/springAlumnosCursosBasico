package com.dawes.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuarios", uniqueConstraints = {
		@UniqueConstraint(name = "USUARIOS_UK", columnNames = "User_Name") })
public class UsuarioVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "User_Id", nullable = false)
	private Long userId;
	
	@Column(name = "User_Name", length = 36, nullable = false)
	private String userName;
	
	@Column(name = "EncrytedPassword", length = 128, nullable = false)
	private String encrytedPassword;
	
	@Column(name = "Enabled", length = 1, nullable = false)
	private boolean enabled;
	
	@OneToMany(mappedBy="usuario", fetch=FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
	private List<UsuarioRolVO> roles;
	
	public UsuarioVO(Long userId, String userName, String encrytedPassword, boolean enabled, List<UsuarioRolVO> roles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.enabled = enabled;
		this.roles = roles;
	}

	public UsuarioVO() {
		super();
		this.roles = new ArrayList<UsuarioRolVO>();
		// TODO Auto-generated constructor stub
	}

	public UsuarioVO(String userName, String encrytedPassword, boolean enabled, List<UsuarioRolVO> roles) {
		super();
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.enabled = enabled;
		this.roles = roles;
	}

	public UsuarioVO(String userName, String encrytedPassword, List<UsuarioRolVO> roles) {
		super();
		this.userName = userName;
		this.encrytedPassword = encrytedPassword;
		this.roles = roles;
	}
	
	public void addRol(UsuarioRolVO urv) {
		this.roles.add(urv);
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getEncrytedPassword() {
		return encrytedPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public List<UsuarioRolVO> getRoles() {
		return roles;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setRoles(List<UsuarioRolVO> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UsuarioVO [userId=" + userId + ", userName=" + userName + ", encrytedPassword=" + encrytedPassword
				+ ", enabled=" + enabled + "]";
	}
	
	
	

}
