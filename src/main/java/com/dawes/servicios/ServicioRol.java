package com.dawes.servicios;

import java.util.Optional;

import com.dawes.modelo.RolVO;

public interface ServicioRol {

	<S extends RolVO> S save(S entity);

	Optional<RolVO> findById(Long id);

	Iterable<RolVO> findAll();

	void deleteById(Long id);

	void delete(RolVO entity);

}