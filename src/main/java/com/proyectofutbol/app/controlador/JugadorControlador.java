package com.proyectofutbol.app.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyectofutbol.app.variables.Jugador;
import com.proyectofutbol.app.variables.Club;
import com.proyectofutbol.app.repositorio.JugadorRepositorio;
import com.proyectofutbol.app.repositorio.ClubRepositorio;

@Controller
public class JugadorControlador {

	@Autowired
    private JugadorRepositorio jugadorRepositorio;
	
	@Autowired
	private ClubRepositorio clubRepositorio;

    @GetMapping("/mostrarJugadores")
    public String listarJugadores(Model model) {
        List<Jugador> listaJugadores = jugadorRepositorio.findAll();
        model.addAttribute("listaJugadores", listaJugadores);
        return "mostrarJugadores";
    }

    @GetMapping("/mostrarJugadores/formJugador")
    public String mostrarFormulario(Model model) {
        model.addAttribute("jugador", new Jugador());
        
        List<Club> listaClubes = clubRepositorio.findAll();
        model.addAttribute("listaClubes",listaClubes);
        return "crearJugador";
    }

    @PostMapping("/guardarJugador")
    public String guardarJugador(Jugador jugador) {
    	
    	if (jugador.getClub() != null && jugador.getClub().getId() == null) {
            jugador.setClub(null);
        }
    	jugadorRepositorio.save(jugador);
        return "redirect:/mostrarJugadores";
    }

    @GetMapping("/jugador/editar/{id}")
    public String modificarJugador(@PathVariable("id") Integer id, Model model) {
        
    	Jugador jugador = jugadorRepositorio.findById(id).get();
    	model.addAttribute("jugador",jugador);
    	
    	List<Club> listaClubes = clubRepositorio.findAll();
        model.addAttribute("listaClubes",listaClubes);
        
        return "editarJugador";
    }

    @GetMapping("/jugador/eliminar/{id}")
    public String eliminarJugador(@PathVariable("id") Integer id) {
        jugadorRepositorio.deleteById(id);
        return "redirect:/mostrarJugadores";
    }
}
