package com.dawes.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dawes.modelo.CursoVO;
import com.dawes.repositorio.CursoRepository;

@Service
public class ServicioCursoImpl implements ServicioCurso {
	
	@Autowired
	CursoRepository cr;

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioCurso#findByDenominacion(java.lang.String)
	 */
	@Override
	public CursoVO findByDenominacion(String denominacion) {
		return cr.findByDenominacion(denominacion);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioCurso#save(S)
	 */
	@Override
	public <S extends CursoVO> S save(S entity) {
		return cr.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioCurso#findById(java.lang.Integer)
	 */
	@Override
	public Optional<CursoVO> findById(Integer id) {
		return cr.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioCurso#findAll()
	 */
	@Override
	public Iterable<CursoVO> findAll() {
		return cr.findAll();
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioCurso#deleteById(java.lang.Integer)
	 */
	@Override
	public void deleteById(Integer id) {
		cr.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.dawes.servicios.ServicioCurso#delete(com.dawes.modelo.CursoVO)
	 */
	@Override
	public void delete(CursoVO entity) {
		cr.delete(entity);
	}

	public CursoRepository getCr() {
		return cr;
	}

	public void setCr(CursoRepository cr) {
		this.cr = cr;
	}
	
	

}
