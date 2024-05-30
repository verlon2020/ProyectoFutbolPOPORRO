package com.proyectofutbol.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectofutbol.app.variables.Asociacion;
import com.proyectofutbol.app.repositorio.AsociacionRepositorio;

@Controller
public class AsociacionControlador {

	@Autowired
    private AsociacionRepositorio asociacionRepositorio;

    @GetMapping("/mostrarAsociaciones")
    public String listarAsociaciones(Model model) {
        List<Asociacion> listaAsociaciones = asociacionRepositorio.findAll();
        model.addAttribute("listaAsociaciones", listaAsociaciones);
        return "mostrarAsociaciones";
    }

    @GetMapping("/mostrarAsociaciones/formAsociacion")
    public String mostrarFormulario(Model model) {
        model.addAttribute("asociacion", new Asociacion());
        return "crearAsociacion";
    }

    @PostMapping("/guardarAsociacion")
    public String guardarAsociacion(Asociacion asociacion) {
    	if(asociacion.getId() != null && asociacionRepositorio.existsById(asociacion.getId())) {
    		asociacionRepositorio.save(asociacion);
    	}else {
    		asociacionRepositorio.save(asociacion);
    	}
        return "redirect:/mostrarAsociaciones";
    }
    
    @GetMapping("/asociacion/editar/{id}")
    public String modificarAsociacion(@PathVariable("id") Integer id, Model model) {
        Asociacion asociacion = asociacionRepositorio.findById(id).get();
        model.addAttribute("asociacion",asociacion);
      
        return "editarAsociacion";
    }
    
    @GetMapping("/asociacion/eliminar/{id}")
    public String eliminarAsociacion(@PathVariable("id") Integer id) {
        asociacionRepositorio.deleteById(id);
        return "redirect:/mostrarAsociaciones";
    }
}
