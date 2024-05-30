package com.proyectofutbol.app.variables;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="competicion")
public class Competicion {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty
	private String nombre;
	@NotNull
	private int montoPremio;
	
	private LocalDate fechaInicio;

	private LocalDate fechaFin;
	
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
	public int getMontoPremio() {
		return montoPremio;
	}
	public void setMontoPremio(int montoPremio) {
		this.montoPremio = montoPremio;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}