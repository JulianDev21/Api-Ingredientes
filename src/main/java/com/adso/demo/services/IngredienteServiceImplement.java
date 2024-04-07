package com.adso.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adso.demo.models.Ingrediente;
import com.adso.demo.interfaces.IngredienteRepository;
@Service

public class IngredienteServiceImplement implements IngredienteService {
    @Autowired
    private final IngredienteRepository ingredienteRepository;

    public IngredienteServiceImplement(IngredienteRepository ingredienteRepository){
    this.ingredienteRepository = ingredienteRepository;
    }

    public List<Ingrediente> findAll() {
    return (List<Ingrediente>) ingredienteRepository.findAll();
    }

    @SuppressWarnings("null")
    public Ingrediente save(Ingrediente ingrediente) {
    return ingredienteRepository.save(ingrediente);
    }

    @SuppressWarnings("null")
    public Ingrediente findById(Long id) {
    return ingredienteRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public void delete(Ingrediente ingrediente) {
    ingredienteRepository.delete(ingrediente);
    }
}

