package com.example.demo.controllers;

import com.example.demo.models.EstudanteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.EstudanteServece;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/estudantes")
public class EstudanteController {
    @Autowired
    private EstudanteServece estudanteServece;

    @GetMapping
    public ResponseEntity<List<EstudanteModel>> findAll(){
        List<EstudanteModel> resqueste = estudanteServece.findAll();
        return  ResponseEntity.ok().body(resqueste);
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
    public ResponseEntity<EstudanteModel> criarEstudante(@RequestBody EstudanteModel estudanteModel){
        EstudanteModel requeste = estudanteServece.criarEstudante(estudanteModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(estudanteModel.getId()).toUri();
        )
        return  ResponseEntity.created(uri).body(requeste);
    }

    public EstudanteModel atualizar (@PathVariable Long id,@RequestBody EstudanteModel estudanteModel) {
        return estudanteServece.atualizar(id, estudanteModel);
    }

}
