package com.mito_proyecto.repository;

import com.mito_proyecto.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface CursoRepository extends JpaRepository<Curso,Long> {

}
