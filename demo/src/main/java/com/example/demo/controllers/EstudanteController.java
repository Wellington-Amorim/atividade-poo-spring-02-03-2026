package com.example.demo.controllers;

import com.example.demo.models.EstudanteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.EstudanteServece;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/estudantes")
public class EstudanteController {
    @Autowired
    private EstudanteServece estudanteServece;

    @GetMapping
    public List<EstudanteModel> findAll(){
        return  estudanteServece.findAll();
    }

    @GetMapping("/{id}")
    public Optional<EstudanteModel> buscaId(@PathVariable Long id) {
        return estudanteServece.buscaId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        estudanteServece.deleteById(id);
    }

    @PostMapping
    public EstudanteModel criarEstudante(@RequestBody EstudanteModel estudanteModel){
        return  estudanteServece.criarEstudante(estudanteModel);
    }

}
