package com.dawes.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dawes.modelo.RolVO;
import com.dawes.modelo.UsuarioRolVO;
import com.dawes.modelo.UsuarioVO;
import com.dawes.servicios.ServicioRol;
import com.dawes.servicios.ServicioUser;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	ServicioUser su;
	
	@Autowired
	ServicioRol rr;
	
	// Indice de la página
	@RequestMapping("/")
	public String indice(Model modelo) {
		
		return "/principal";
	}
	
	// Este enlace es llamado cuando uno se registra y se comprueba su rol, dependiendo
	// de si es un admin o un usuario te lleva a un lado o a otro
	@RequestMapping("/principal")
	public String principal(Model modelo, Principal principal) {
		
//		String nombre = principal.getName();
//		boolean admin = false;
//		
//		if (nombre.equals("admin")) {
//			admin = true;
//		}
//		
//		modelo.addAttribute("admin", admin);
//		modelo.addAttribute("nombre", nombre);	
//		
//		return "/index";
		
		String nombre = principal.getName();
		
		if (nombre.equals("admin")) {
			return "redirect:/admin/lista";
		} else {
			return "redirect:/registrado/indexRegistrado";
		}
	}
	
	// Enlace para la página de registro
	@RequestMapping("/registro")
	public String registro(Model modelo) {
		modelo.addAttribute("usuario", new UsuarioVO());
		return "/registro";
	}
	
	// Enlace para la página de login
	@RequestMapping("/login")
	public String login(Model modelo) {
		return "/login";
	}
	
	// Enlace para el action del formulario encargado de crear un usuario
	// y registrarlo en la base de datos
	@RequestMapping("/formRegistro")
	public String formRegistro(@ModelAttribute UsuarioVO usuario, Model modelo) {
		
		// Encripto la contraseña del usuario
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		usuario.setEncrytedPassword(encoder.encode(usuario.getEncrytedPassword()));
		
		// Busco el rol para el usuario
		RolVO rol = rr.findById((long) 2).get();
		
		// Activo al usuario
		usuario.setEnabled(true);
		
		// Añado el rol
		UsuarioRolVO urv = new UsuarioRolVO(usuario, rol);
		
		usuario.addRol(urv);
		
		// Guardo en la base de datos
		su.save(usuario);
		return "redirect:/login";
	}
	
	// Página cuando no tienes permisos
	@RequestMapping(value = "/403")
	public String accesoDenegado(Model modelo) {
		
		modelo.addAttribute("message", "No tienes permiso de acceso a esta página");
		
		return "403Page";
	}
	
	// Página principal del admin
	@RequestMapping("/admin")
	public String admin() {
		return "admin/lista";
	}
	
	// Página principal del registrado
	@RequestMapping("/registrado")
	public String registrado() {
		return "registrado/indexRegistrado";
	}
	
	// Logout
	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/logout";
	}

	// Vista para la página de nosotros
	@RequestMapping("/nosotros")
	public String nosotros() {
		return "nosotros";
	}

}
