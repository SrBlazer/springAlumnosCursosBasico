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
@Table(name="alumno")
public class AlumnoVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idalumno;
	
	@Column(unique = true)
	private String nombre;
	
	@OneToMany(mappedBy="alumno",fetch=FetchType.EAGER,cascade= {CascadeType.ALL}, orphanRemoval = true)
	private List<AlumnoCursoVO> cursos;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<AlumnoCursoVO> getCursos() {
		return cursos;
	}
	public void setCursos(List<AlumnoCursoVO> cursos) {
		this.cursos = cursos;
	}
	public AlumnoVO(String nombre, List<AlumnoCursoVO> cursos) {
		super();
		this.nombre = nombre;
		this.cursos = cursos;
	}
	
	
	public int getIdalumno() {
		return idalumno;
	}
	public void setIdalumno(int idalumno) {
		this.idalumno = idalumno;
	}
	public AlumnoVO(String nombre) {
		this.nombre=nombre;
		cursos=new ArrayList();
	}
	public AlumnoVO() {
		cursos=new ArrayList();
	}
	public void addCurso(AlumnoCursoVO ac) {
		this.cursos.add(ac);
	}
	public List<AlumnoCursoVO> removeCurso(CursoVO c) {
		Iterator<AlumnoCursoVO> it=cursos.iterator();
		AlumnoCursoVO a=new AlumnoCursoVO();
		while(it.hasNext()) {
			a=it.next();
			if (c.equals(a.getCurso()))
				it.remove();
		}
		return cursos;
	}
	
	public void limpiarCursos() {
		this.cursos.clear();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		AlumnoVO other = (AlumnoVO) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AlumnoVO [nombre=" + nombre + "]";
	}
	
}
