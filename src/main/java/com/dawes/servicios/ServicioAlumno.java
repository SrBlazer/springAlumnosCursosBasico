package com.dawes.servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.dawes.modelo.AlumnoVO;
import com.dawes.repositorio.AlumnoRepository;

public interface ServicioAlumno {

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#findByNombre(java.lang.String)
	 */
	AlumnoVO findByNombre(String nombre);

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#save(S)
	 */
	<S extends AlumnoVO> S save(S entity);

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#findById(java.lang.Integer)
	 */
	Optional<AlumnoVO> findById(Integer id);

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#findAll()
	 */
	Iterable<AlumnoVO> findAll();

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#deleteById(java.lang.Integer)
	 */
	void deleteById(Integer id);

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#delete(com.dawes.modelo.AlumnoVO)
	 */
	void delete(AlumnoVO entity);

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioAlumno#deleteAll()
	 */
	void deleteAll();

	AlumnoRepository getAr();

	void setAr(AlumnoRepository ar);

	List<AlumnoVO> findAllByCursosFechaBetween(LocalDate inicio, LocalDate fin);

	List<AlumnoVO> findByFechaBetween(LocalDate fecha1, LocalDate fecha2);
	
	List<AlumnoVO> encontrarPorInicial(String letra);

}