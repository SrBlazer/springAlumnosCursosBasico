package com.dawes.modelo;

import java.util.ArrayList;
import java.util.Iterator;
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


@Entity
@Table(name="curso")
public class CursoVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcurso;
	
	@Column(unique = true)
	private String denominacion;
	
	@OneToMany(mappedBy="curso", fetch=FetchType.EAGER)
	private List<AlumnoCursoVO> alumnos;
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public List<AlumnoCursoVO> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<AlumnoCursoVO> alumnos) {
		this.alumnos = alumnos;
	}
	
	public CursoVO(String denominacion, List<AlumnoCursoVO> alumnos) {
		super();
		this.denominacion = denominacion;
		this.alumnos = alumnos;
	}
	public CursoVO(String denominacion) {
		this.denominacion=denominacion;
		alumnos=new ArrayList();
	}
	public CursoVO() {
		super();
		alumnos=new ArrayList();
	}
	public void addAlumno(AlumnoCursoVO ac) {
		this.alumnos.add(ac);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denominacion == null) ? 0 : denominacion.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoVO other = (CursoVO) obj;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CursoVO [denominacion=" + denominacion + "]";
	}
	public int getIdcurso() {
		return idcurso;
	}
	public void setIdcurso(int idcurso) {
		this.idcurso = idcurso;
	}
	
	

	
	
	

}
