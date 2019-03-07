package com.dawes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuariorol", uniqueConstraints = { @UniqueConstraint(name = "USUARIO_ROL_UK", columnNames = {"User_Id", "Role_Id"}) })
public class UsuarioRolVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "User_Id", nullable = false)
	private UsuarioVO usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Role_Id", nullable = false)
	private RolVO rol;

	public UsuarioRolVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioRolVO(Long id, UsuarioVO usuario, RolVO rol) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.rol = rol;
	}

	public UsuarioRolVO(UsuarioVO usuario, RolVO rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public UsuarioVO getUsuario() {
		return usuario;
	}

	public RolVO getRol() {
		return rol;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsuario(UsuarioVO usuario) {
		this.usuario = usuario;
	}

	public void setRol(RolVO rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "UsuarioRolVO [id=" + id + ", usuario=" + usuario + ", rol=" + rol + "]";
	}
	
	
	
	

}
