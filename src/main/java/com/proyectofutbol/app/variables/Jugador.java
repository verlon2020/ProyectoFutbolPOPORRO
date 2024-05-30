package com.proyectofutbol.app.variables;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="jugador")
public class Jugador {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotNull
	private int numero;
	
	@NotEmpty
	private String posicion;
	
	@ManyToOne
    @JoinColumn(name = "id_club")
    private Club club;
	
	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	
	
}
