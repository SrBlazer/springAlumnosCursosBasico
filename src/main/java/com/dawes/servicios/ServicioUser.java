package com.dawes.servicios;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dawes.modelo.UsuarioVO;

public interface ServicioUser {

	UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;

	<S extends UsuarioVO> S save(S entity);

	Iterable<UsuarioVO> findAll();

	long count();

	void deleteById(Integer id);

	void delete(UsuarioVO entity);
	
	UsuarioVO findUserAccount(String userName);

}