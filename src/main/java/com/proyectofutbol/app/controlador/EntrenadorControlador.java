package com.proyectofutbol.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectofutbol.app.variables.Entrenador;
import com.proyectofutbol.app.repositorio.EntrenadorRepositorio;

@Controller
public class EntrenadorControlador {

	@Autowired
    private EntrenadorRepositorio entrenadorRepositorio;

    @GetMapping("/mostrarEntrenadores")
    public String listarEntrenadores(Model model) {
        List<Entrenador> listaEntrenadores = entrenadorRepositorio.findAll();
        model.addAttribute("listaEntrenadores", listaEntrenadores);
        return "mostrarEntrenadores";
    }

    @GetMapping("/mostrarEntrenadores/formEntrenador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        return "crearEntrenador";
    }

    @PostMapping("/guardarEntrenador")
    public String guardarEntrenador(@ModelAttribute("entrenador") Entrenador entrenador) {
      
        if (entrenador.getId() != null && entrenadorRepositorio.existsById(entrenador.getId())) {
            entrenadorRepositorio.save(entrenador);
        } else {
            entrenadorRepositorio.save(entrenador);
        }
        return "redirect:/mostrarEntrenadores";
    }

    @GetMapping("/entrenador/editar/{id}")
    public String modificarEntrenador(@PathVariable("id") Integer id, Model model) {
    	
    	Entrenador entrenador = entrenadorRepositorio.findById(id).get();
    	model.addAttribute("entrenador",entrenador);
    	
    	return "editarEntrenador";
    }

    @GetMapping("/entrenador/eliminar/{id}")
    public String eliminarEntrenador(@PathVariable("id") Integer id) {
        entrenadorRepositorio.deleteById(id);
        return "redirect:/mostrarEntrenadores";
    }
}
