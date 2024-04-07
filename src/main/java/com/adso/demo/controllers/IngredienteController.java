package com.adso.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import com.adso.demo.models.Ingrediente;
import com.adso.demo.services.IngredienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/demo")

public class IngredienteController {
    
    private final IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService){
        this.ingredienteService = ingredienteService;
    }

    @GetMapping(value="/ingredientes")
    public ResponseEntity<Object> get(){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Ingrediente> list = ingredienteService.findAll();
            return new ResponseEntity<Object>(list,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/ingredientes/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            Ingrediente data = ingredienteService.findById(id);
            return new ResponseEntity<Object>(data,HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value="/ingredientes")
    public ResponseEntity<Object> create(@RequestBody Ingrediente ingrediente){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Ingrediente res = ingredienteService.save(ingrediente);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/ingredientes/{id}")
    public ResponseEntity<Object> update(@RequestBody Ingrediente ingrediente, @PathVariable Long
id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {

            Ingrediente existingIngrediente = ingredienteService.findById(id);

            existingIngrediente.setProducto(ingrediente.getProducto());
            existingIngrediente.setCategoria(ingrediente.getCategoria());
            existingIngrediente.setCantidad(ingrediente.getCantidad());
            existingIngrediente.setUnd_medida(ingrediente.getUnd_medida());
            existingIngrediente.setDias_caducidad(ingrediente.getDias_caducidad());
            existingIngrediente.setProveedor(ingrediente.getProveedor());
            existingIngrediente.setCreateAt(ingrediente.getCreateAt());

            Ingrediente res = ingredienteService.save(ingrediente);

            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/ingredientes/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Ingrediente existingIngrediente = ingredienteService.findById(id);
            ingredienteService.delete(existingIngrediente);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}   