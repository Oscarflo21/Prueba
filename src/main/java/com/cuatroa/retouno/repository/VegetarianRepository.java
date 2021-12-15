package com.cuatroa.retouno.repository;

import com.cuatroa.retouno.model.Vegetarian;
import com.cuatroa.retouno.repository.crud.VegetarianCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guarn
 */
@Repository
public class VegetarianRepository {
    
    @Autowired
    private VegetarianCrudRepository repository;

    /**
     * 
     * @return 
     */    
    public List<Vegetarian> getAll() {
        return (List<Vegetarian>) repository.findAll();
    }
    
    /**
     * 
     * @param vegetarian
     * @return 
     */
    public Vegetarian save(Vegetarian vegetarian) {
        return repository.save(vegetarian);
    }
    
    /**
     * 
     * @param reference
     * @return 
     */
    public Optional<Vegetarian> getVegetarianByReference(String reference){
        return repository.findByReference(reference); 
    }

    /**
     * 
     */    
    public void deleteByReference(String reference){
        repository.deleteByReference(reference);
    }
    /**
     * 
     * @param vegetarian 
     */
    public void delete(Vegetarian vegetarian){
        repository.delete(vegetarian);
    }

    public void updateVegetarian(Vegetarian get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Optional<Vegetarian> getVegetarian(String reference) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
