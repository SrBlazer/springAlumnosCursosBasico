package com.dawes.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dawes.modelo.AlumnoVO;

@Repository
public interface AlumnoRepository extends CrudRepository<AlumnoVO, Integer> {

	
	
	/*
	 * Spring tiene un mecanismo generador de consultas integrado, útil para crear consultas
	 * en base a las entidades del repositorio. El nombre del método tiene un prefijo findBy
	 * y comienza a analizar el resto del mismo.  Las expresiones son generalmente recorridos
	 * de propiedades combinados con operadores que pueden ser concatenados, AND, OR, Between… 
	 * Las expresiones de propiedad solo pueden referirse a propiedades directas de la entidad,
	 *  pero también se pueden atravesar propiedades anidadas 
	 */
	
	AlumnoVO findByNombre(String nombre);
	
	// Programo la consulta aprovechando el generador de consultas integrado
	List<AlumnoVO> findAllByCursosFechaBetween(LocalDate inicio, LocalDate fin);
	
	// La mimsa consulta utilizando HQL
	@Query("select a from AlumnoVO a join fetch a.cursos ac where ac.fecha between :fecha1 and :fecha2")
	List<AlumnoVO> findByFechaBetween(@Param("fecha1") LocalDate fecha1, @Param("fecha2") LocalDate fecha2);
	
	// Método para buscar un nombre por inicial
	@Query("select a from AlumnoVO as a where a.nombre like :letra%")
	List<AlumnoVO> encontrarPorInicial(@Param("letra") String letra);

}
