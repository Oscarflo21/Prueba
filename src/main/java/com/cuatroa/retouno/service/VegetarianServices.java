package com.cuatroa.retouno.service;

import com.cuatroa.retouno.model.Vegetarian;
import com.cuatroa.retouno.repository.VegetarianRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guarn
 */
@Service
public class VegetarianServices {
    /**
     * 
     */
    @Autowired
    private VegetarianRepository repository;
    
    /**
     * 
     * @return 
     */
    public List<Vegetarian> getAll() {
        return repository.getAll();
    }
    
    /**
     * 
     * @param reference
     * @return 
     */
    public Optional<Vegetarian> getVegetarian(String reference) {
		return repository.getVegetarian(reference);
	}
    
    /**
     * 
     * @param vegetarian
     * @return 
     */
    public Vegetarian save(Vegetarian vegetarian) {
		if (vegetarian.getReference() == null) {
			return vegetarian;
		} else {
			return repository.save(vegetarian);
		}
    }
    
    /**
     * 
     * @param vegetarian
     * @return 
     */
    public Vegetarian update(Vegetarian vegetarian) {
        if (vegetarian.getReference()!= null) {
            Optional<Vegetarian> vegetarianExist = repository.getVegetarianByReference(vegetarian.getReference());
		if (vegetarianExist.isPresent()) {
                    if (vegetarian.getBrand() != null) {
                        vegetarianExist.get().setBrand(vegetarian.getBrand());
                    }
                    if (vegetarian.getCategory() != null) {
                        vegetarianExist.get().setCategory(vegetarian.getCategory());
                    }
                    if (vegetarian.getDescription() != null) {
                        vegetarianExist.get().setDescription(vegetarian.getDescription());
                    }
                    if (vegetarian.getPrice() != 0.0) {
                        vegetarianExist.get().setPrice(vegetarian.getPrice());
                    }
                    if (vegetarian.getQuantity() != 0) {
                        vegetarianExist.get().setQuantity(vegetarian.getQuantity());
                    }
                    if (vegetarian.getPhotography() != null) {
                        vegetarianExist.get().setPhotography(vegetarian.getPhotography());
                    }
                    return repository.save(vegetarianExist.get());
		} else {
                    return vegetarian;
		}
            } else {
		return vegetarian;
            }
    }
    
    /**
     * 
     * @param reference
     * @return 
     */
    public boolean deleteByReference(String reference) {
		Boolean vBoolean = repository.getVegetarianByReference(reference).map(vegetarian -> {
			repository.deleteByReference(reference);
			return true;
		}).orElse(false);
		return vBoolean;
    }
    
    
}
