package com.dawes.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dawes.modelo.UsuarioRolVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.repositorio.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService, ServicioUser {

	@Autowired
	private UserRepository ur;

	@Autowired
	private EntityManager entityManager;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dawes.servicios.ServicioUser#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UsuarioVO u = ur.findUserAccount(userName);

		if (u == null) {
			System.out.println("Usuario no encontrado " + userName);
			throw new UsernameNotFoundException("Usuario " + userName + " no existe en la base de datos");
		}

		System.out.println("Usuario encontrado " + userName + " con rol " + u.getRoles().toString());

		// [ROLE_USER, ROLE_ADMIN, ...]

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

		if (u.getRoles() != null) {
			for (UsuarioRolVO role : u.getRoles()) {
				// ROLE_USER, ROLE_ADMIN, ...
				GrantedAuthority authority = new SimpleGrantedAuthority(role.getRol().getRoleName());
				grantList.add(authority);
			}
		}

		UserDetails userDetails = new User(u.getUserName(), u.getEncrytedPassword(), grantList);

		return userDetails;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dawes.servicios.ServicioUser#save(S)
	 */
	@Override
	public <S extends UsuarioVO> S save(S entity) {
		return ur.save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dawes.servicios.ServicioUser#findAll()
	 */
	@Override
	public Iterable<UsuarioVO> findAll() {
		return ur.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dawes.servicios.ServicioUser#count()
	 */
	@Override
	public long count() {
		return ur.count();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dawes.servicios.ServicioUser#deleteById(java.lang.Integer)
	 */
	@Override
	public void deleteById(Integer id) {
		ur.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dawes.servicios.ServicioUser#delete(com.dawes.modelo.UsuarioVO)
	 */
	@Override
	public void delete(UsuarioVO entity) {
		ur.delete(entity);
	}

	@Override
	public UsuarioVO findUserAccount(String userName) {

//		try {
//
//			Query query = entityManager.createQuery("select u from UsuarioVO u where u.userName =: nombre",
//					UsuarioVO.class);
//			query.setParameter("nombre", userName);
//
//			//return (UsuarioVO) query.getSingleResult();
//			return ur.findUserAccount(userName);
//
//		} catch (NoResultException e) {
//			return null;
//		}
		return ur.findUserAccount(userName);
	}

}
