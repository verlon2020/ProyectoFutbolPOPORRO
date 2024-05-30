package com.proyectofutbol.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectofutbol.app.variables.Asociacion;
import com.proyectofutbol.app.variables.Club;
import com.proyectofutbol.app.variables.Competicion;
import com.proyectofutbol.app.variables.Entrenador;
import com.proyectofutbol.app.repositorio.AsociacionRepositorio;
import com.proyectofutbol.app.repositorio.ClubRepositorio;
import com.proyectofutbol.app.repositorio.CompeticionRepositorio;
import com.proyectofutbol.app.repositorio.EntrenadorRepositorio;

@Controller
public class ClubControlador {
	
	@Autowired
	private ClubRepositorio clubRepositorio;
	
	@Autowired
	private EntrenadorRepositorio entrenadorRepositorio;
	
	@Autowired
	private AsociacionRepositorio asociacionRepositorio;
	
	@Autowired
	private CompeticionRepositorio competicionRepositorio;
	
	
	@GetMapping({"/mostrarClub"})
	public String listarClub(Model model) {
		List<Club> listaClub = clubRepositorio.findAll();
		model.addAttribute("listaClub", listaClub);
		
		return "mostrarClub";
	}
	
	@GetMapping("/mostrarClub/formClub")
	public String mostrarFormulario(Model model) {
		model.addAttribute("club", new Club());
		
		List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador",listaEntrenador);
		
		List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion",listaAsociacion);
		
		List<Competicion> listaCompeticion = competicionRepositorio.findAll();
		model.addAttribute("listaCompeticion",listaCompeticion);
		
		return "crearClub";
	}
	
	@PostMapping("/guardarClub")
	public String guardarClub (Club club) {
		
		if(club.getId() != null && clubRepositorio.existsById(club.getId())) {
			clubRepositorio.save(club);
		}else {
			clubRepositorio.save(club);
		}
		return "redirect:/mostrarClub";
	}

	
	@GetMapping("/club/editar/{id}")
	public String modificarClub(@PathVariable("id") Integer id, Model model) {
		
		Club club = clubRepositorio.findById(id).get();
		model.addAttribute("club", club);
		
		List<Entrenador> listaEntrenador = entrenadorRepositorio.findAll();
		model.addAttribute("listaEntrenador", listaEntrenador);
		
		List<Asociacion> listaAsociacion = asociacionRepositorio.findAll();
		model.addAttribute("listaAsociacion", listaAsociacion);
		
		List<Competicion> listaCompeticion = competicionRepositorio.findAll();
		model.addAttribute("listaCompeticion", listaCompeticion);
		
		return "editarClub";
	}
	
	@GetMapping("/club/eliminar/{id}")
	public String eliminarClub(@PathVariable("id") Integer id) {
		clubRepositorio.deleteById(id);
		return "redirect:/mostrarClub";
	}
}
