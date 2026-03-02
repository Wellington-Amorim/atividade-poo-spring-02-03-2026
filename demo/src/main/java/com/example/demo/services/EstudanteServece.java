package com.example.demo.services;

import com.example.demo.models.EstudanteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.EstudanteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteServece {
    @Autowired
    private EstudanteRepository estudanteRepository;

    public List<EstudanteModel> findAll() {
        return estudanteRepository.findAll();
    }
    public EstudanteModel criarEstudante(EstudanteModel estudanteModel) {
        return estudanteRepository.save(estudanteModel);
    }
    public Optional<EstudanteModel> buscaId(Long id) {
        return estudanteRepository.findById(id);
    }
    public void deleteById(Long id) {
        estudanteRepository.deleteById(id);
    }
}
