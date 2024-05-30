package com.proyectofutbol.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectofutbol.app.variables.Competicion;

public interface CompeticionRepositorio extends JpaRepository<Competicion, Integer> {

}
