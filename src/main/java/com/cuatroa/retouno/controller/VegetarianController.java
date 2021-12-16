package com.cuatroa.retouno.controller;

import com.cuatroa.retouno.model.Vegetarian;
import com.cuatroa.retouno.service.VegetarianServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guarn
 */
@RestController
@RequestMapping("vegetarian")
@CrossOrigin(origins= "*")
public class VegetarianController {
    /**
     * 
     */
    @Autowired
    private VegetarianServices service;

    /**
     * 
     * @return 
     */
    @GetMapping("/all")
    public List<Vegetarian> getVegetarians(){
        return service.getAll();
    }   
    
    /**
     * 
     * @param vegetarian
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Vegetarian save(@RequestBody Vegetarian vegetarian){
        return service.save(vegetarian);
    }
    
    /**
     * 
     * @param vegetarian
     * @return 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Vegetarian update(@RequestBody Vegetarian vegetarian){
        return service.update(vegetarian);
    }
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return service.deleteReference(reference);
    }
    
}