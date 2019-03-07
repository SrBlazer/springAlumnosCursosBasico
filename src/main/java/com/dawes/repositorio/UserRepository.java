package com.dawes.repositorio;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.UsuarioVO;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<UsuarioVO, Integer> {
	
//	@Autowired
//	private EntityManager entityManager;
//	
//	
//	public UsuarioVO findUserAccount(String userName) {
//		
//		try {
//			
//			Query query = entityManager.createQuery("select u from UsuarioVO u where u.userName =: nombre", UsuarioVO.class);
//			query.setParameter("nombre", userName);
//			
//			return (UsuarioVO) query.getSingleResult();
//			
//		} catch (NoResultException e) {
//			return null;
//		}
//	}
	
	@Query("select u from UsuarioVO u where u.userName = :nombre")
	UsuarioVO findUserAccount(@Param("nombre") String userName);

}
