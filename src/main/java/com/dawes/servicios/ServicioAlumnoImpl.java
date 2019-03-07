package com.dawes.servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.AlumnoVO;
import com.dawes.repositorio.AlumnoRepository;

@Service
public class ServicioAlumnoImpl implements ServicioAlumno  {
	
	@Autowired
	AlumnoRepository ar;

	public List<AlumnoVO> encontrarPorInicial(String letra) {
		return ar.encontrarPorInicial(letra);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#findByNombre(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#findByNombre(java.lang.String)
	 */
	@Override
	public AlumnoVO findByNombre(String nombre) {
		return ar.findByNombre(nombre);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#save(S)
	 */
	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#save(S)
	 */
	@Override
	public <S extends AlumnoVO> S save(S entity) {
		return ar.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#findById(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#findById(java.lang.Integer)
	 */
	@Override
	public Optional<AlumnoVO> findById(Integer id) {
		return ar.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#findAll()
	 */
	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#findAll()
	 */
	@Override
	public Iterable<AlumnoVO> findAll() {
		return ar.findAll();
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#deleteById(java.lang.Integer)
	 */
	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#deleteById(java.lang.Integer)
	 */
	@Override
	public void deleteById(Integer id) {
		ar.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#delete(com.dawes.modelo.AlumnoVO)
	 */
	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#delete(com.dawes.modelo.AlumnoVO)
	 */
	@Override
	public void delete(AlumnoVO entity) {
		ar.delete(entity);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#deleteAll()
	 */
	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#deleteAll()
	 */
	@Override
	public void deleteAll() {
		ar.deleteAll();
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#getAr()
	 */
	@Override
	public AlumnoRepository getAr() {
		return ar;
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#setAr(com.dawes.repositorio.AlumnoRepository)
	 */
	@Override
	public void setAr(AlumnoRepository ar) {
		this.ar = ar;
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#findAllByCursosFechaBetween(java.time.LocalDate, java.time.LocalDate)
	 */
	@Override
	public List<AlumnoVO> findAllByCursosFechaBetween(LocalDate inicio, LocalDate fin) {
		return ar.findAllByCursosFechaBetween(inicio, fin);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#findByFechaBetween(java.time.LocalDate, java.time.LocalDate)
	 */
	@Override
	public List<AlumnoVO> findByFechaBetween(LocalDate fecha1, LocalDate fecha2) {
		return ar.findByFechaBetween(fecha1, fecha2);
	}
	
	
}
