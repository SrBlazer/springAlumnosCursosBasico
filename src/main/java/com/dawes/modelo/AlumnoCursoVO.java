package com.dawes.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="alumnocurso")
public class AlumnoCursoVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idalumnocurso;
	private LocalDate fecha;
	
	@ManyToOne
	@JoinColumn(name="idalumno")
	private AlumnoVO alumno;
	
	@ManyToOne
	@JoinColumn(name="idcurso")
	private CursoVO curso;

	public int getIdalumnocurso() {
		return idalumnocurso;
	}

	public void setIdalumnocurso(int idalumnocurso) {
		this.idalumnocurso = idalumnocurso;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public AlumnoVO getAlumno() {
		return alumno;
	}

	public void setAlumno(AlumnoVO alumno) {
		this.alumno = alumno;
	}

	public CursoVO getCurso() {
		return curso;
	}

	public void setCurso(CursoVO curso) {
		this.curso = curso;
	}

	public AlumnoCursoVO(int idalumnocurso, LocalDate fecha, AlumnoVO alumno, CursoVO curso) {
		super();
		this.idalumnocurso = idalumnocurso;
		this.fecha = fecha;
		this.alumno = alumno;
		this.curso = curso;
	}

	public AlumnoCursoVO(LocalDate fecha, AlumnoVO alumno, CursoVO curso) {
		super();
		this.fecha = fecha;
		this.alumno = alumno;
		this.curso = curso;
	}

	public AlumnoCursoVO() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
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
		AlumnoCursoVO other = (AlumnoCursoVO) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlumnoCursoVO [alumno=" + alumno + ", curso=" + curso + "]";
	}
	
	

}
