package com.adso.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adso.demo.models.Ingrediente;
@Service

public interface IngredienteService {

    public List<Ingrediente> findAll();

    public Ingrediente save(Ingrediente ingrediente);

    public Ingrediente findById(Long id);
    
    public void delete(Ingrediente ingrediente);

}
