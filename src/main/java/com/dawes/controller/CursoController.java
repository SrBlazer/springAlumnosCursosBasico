package com.dawes.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dawes.modelo.CursoVO;
import com.dawes.servicios.ServicioCurso;

@Controller
@RequestMapping("/")
public class CursoController {

	@Autowired
	ServicioCurso sc;
	
	// Mapeo para el admin
	@RequestMapping("/admin/listaCursos")
	public String lista(Model modelo) {
		modelo.addAttribute("listaCurso", sc.findAll());
		return "/admin/listaCursos";
	}
	
	@RequestMapping("/admin/formInsertaCurso")
	public String formInsertaCurso(Model modelo) {
		modelo.addAttribute("curso", new CursoVO());
		return "/admin/formInsertaCursos";
	}
	
	@RequestMapping("/admin/insertaCurso")
	public String insertaCurso(@ModelAttribute CursoVO curso, Model modelo) {
		String errorCurso = "";
		try {
			sc.save(curso);
			modelo.addAttribute("listaCurso", sc.findAll());
			return "redirect:/admin/listaCursos";
		} catch (Exception e) {
			errorCurso = "?errorCurso=Ese curso ya existe";
			return "redirect:/admin/listaCursos" + errorCurso;
		}

	}
	
	@RequestMapping("/admin/eliminaCurso")
	public String eliminaCurso(@RequestParam int idcurso, Model modelo) {
		sc.delete(sc.findById(idcurso).get());
		modelo.addAttribute("listaCurso", sc.findAll());
		
		return "redirect:/admin/listaCursos";
	}
	
	@RequestMapping("/admin/modificaCurso")
	public String modificaCurso(@RequestParam int idcurso, Model modelo) {
		modelo.addAttribute("curso", sc.findById(idcurso).get());
		
		return "/admin/formModificaCurso";
	}
	
	@RequestMapping("/admin/guardaCurso")
	public String guarda(@ModelAttribute CursoVO curso, Model modelo) {
		Optional<CursoVO> curso_intermedio = sc.findById(curso.getIdcurso());
		curso.setAlumnos(curso_intermedio.get().getAlumnos());
		sc.save(curso);
		modelo.addAttribute("listaCurso", sc.findAll());
		return "redirect:/admin/listaCursos";
	}
	

}
