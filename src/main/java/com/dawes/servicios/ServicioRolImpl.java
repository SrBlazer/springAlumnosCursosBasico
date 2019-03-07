package com.dawes.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.RolVO;
import com.dawes.repositorio.RolRepository;

@Service
public class ServicioRolImpl implements ServicioRol {

	@Autowired
	RolRepository rr;

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioRol#save(S)
	 */
	@Override
	public <S extends RolVO> S save(S entity) {
		return rr.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioRol#findById(java.lang.Integer)
	 */
	@Override
	public Optional<RolVO> findById(Long id) {
		return rr.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioRol#findAll()
	 */
	@Override
	public Iterable<RolVO> findAll() {
		return rr.findAll();
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioRol#deleteById(java.lang.Integer)
	 */
	@Override
	public void deleteById(Long id) {
		rr.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioRol#delete(com.dawes.modelo.RolVO)
	 */
	@Override
	public void delete(RolVO entity) {
		rr.delete(entity);
	}
}
