package com.proyectofutbol.app.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import com.proyectofutbol.app.variables.Club;

public interface ClubRepositorio extends JpaRepository<Club, Integer> {

}
