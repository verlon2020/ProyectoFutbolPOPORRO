package com.proyectofutbol.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectofutbol.app.variables.Competicion;
import com.proyectofutbol.app.repositorio.CompeticionRepositorio;

@Controller
public class CompeticionControlador {

	@Autowired
    private CompeticionRepositorio competicionRepositorio;

    @GetMapping("/mostrarCompeticiones")
    public String listarCompeticiones(Model model) {
        List<Competicion> listaCompeticiones = competicionRepositorio.findAll();
        model.addAttribute("listaCompeticiones", listaCompeticiones);
        return "mostrarCompeticiones";
    }

    @GetMapping("/mostrarCompeticiones/formCompeticion")
    public String mostrarFormulario(Model model) {
        model.addAttribute("competicion", new Competicion());
        return "crearCompeticion";
    }

    @PostMapping("/guardarCompeticion")
    public String guardarCompeticion(Competicion competicion) {
    	
    	if(competicion.getId() != null && competicionRepositorio.existsById(competicion.getId())) {
    		competicionRepositorio.save(competicion);
    	}else {
    		competicionRepositorio.save(competicion);
    	}
        return "redirect:/mostrarCompeticiones";
    }

    @GetMapping("/competicion/editar/{id}")
    public String modificarCompeticion(@PathVariable("id") Integer id, Model model) {
        
    	Competicion competicion = competicionRepositorio.findById(id).get();
        model.addAttribute("competicion",competicion);
    	
    	return "editarCompeticion";
        
    }

    @GetMapping("/competicion/eliminar/{id}")
    public String eliminarCompeticion(@PathVariable("id") Integer id) {
        competicionRepositorio.deleteById(id);
        return "redirect:/mostrarCompeticiones";
    }
}
