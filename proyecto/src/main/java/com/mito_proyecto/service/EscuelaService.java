package com.mito_proyecto.service;

import com.mito_proyecto.model.Curso;
import com.mito_proyecto.model.Estudiante;
import com.mito_proyecto.repository.CursoRepository;
import com.mito_proyecto.repository.DetalleMatriculaRepository;
import com.mito_proyecto.repository.EstudianteRepository;
import com.mito_proyecto.repository.RegistrarMatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EscuelaService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private DetalleMatriculaRepository detalleMatriculaRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private RegistrarMatriculaRepository registrarMatriculaRepository;


    public List<Estudiante> ordenarPorEdad(List<Estudiante> estudiantes){
        return estudianteRepository.findAll().stream().sorted((e1,e2) -> Integer.compare(e1.getEdad() , e2.getEdad()))
                .collect(Collectors.toList());
    }

    public List<Estudiante> obtenerTodo(){
        return estudianteRepository.findAll();
    }

    public Map<String, List<String>> getCursoYalumno(){
        List<Curso> cursos = cursoRepository.findAll();

        return cursos.stream()
                .collect(Collectors.toMap(
                        Curso::getNombre,
                        curso -> curso.getEstudiantes().stream()
                                .map(estudiante -> estudiante.getNombres() + " " + estudiante.getApellidos())
                                .collect(Collectors.toList())
                ));
    }

}
