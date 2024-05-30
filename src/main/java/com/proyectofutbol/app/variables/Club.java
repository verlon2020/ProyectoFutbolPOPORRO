package com.proyectofutbol.app.variables;

import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="club")
public class Club {
	
	@Id
	@Column(name="id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@NotNull
	private String nombre;

	@OneToOne
	private Entrenador entrenador;
	
	@OneToMany
	@JoinColumn(name="id_club")
	private List<Jugador>jugadores;
	
	@ManyToOne
	private Asociacion asociacion;
	
	@ManyToMany
	private List<Competicion> competiciones;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Asociacion getAsociacion() {
		return asociacion;
	}

	public void setAsociacion(Asociacion asociacion) {
		this.asociacion = asociacion;
	}

	public List<Competicion> getCompeticiones() {
		return competiciones;
	}

	public void setCompeticiones(List<Competicion> competiciones) {
		this.competiciones = competiciones;
	}

	
	
	
}
