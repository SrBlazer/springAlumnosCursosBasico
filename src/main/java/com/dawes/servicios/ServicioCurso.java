package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.CursoVO;

public interface ServicioCurso {

	CursoVO findByDenominacion(String denominacion);

	<S extends CursoVO> S save(S entity);

	Optional<CursoVO> findById(Integer id);

	Iterable<CursoVO> findAll();

	void deleteById(Integer id);

	void delete(CursoVO entity);

}