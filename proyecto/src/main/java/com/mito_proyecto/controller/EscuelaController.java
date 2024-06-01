package com.mito_proyecto.controller;

import com.mito_proyecto.model.Estudiante;
import com.mito_proyecto.service.EscuelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("estudiantes")
public class EscuelaController {

    @Autowired
    private EscuelaService escuelaService;




    @GetMapping("/orden")
    public List<Estudiante> listarEstudiantesOrden(){

        List<Estudiante> estudiantes = escuelaService.obtenerTodo();
        return escuelaService.ordenarPorEdad(estudiantes);
    }

    @GetMapping("/obtenerCusoYEstudiante")
    public Map<String, List<String>> listarCursoYEstudiante(){
        return escuelaService.getCursoYalumno();
    }
}
