package com.mito_proyecto.repository;

import com.mito_proyecto.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {

    @Override
    List<Estudiante> findAll();

    List<Estudiante> ordenarPorEdad(List<Estudiante> estudiantes);

}
