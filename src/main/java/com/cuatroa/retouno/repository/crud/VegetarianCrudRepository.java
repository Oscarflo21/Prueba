package com.cuatroa.retouno.repository.crud;

import com.cuatroa.retouno.model.Vegetarian;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author guarn
 */
public interface VegetarianCrudRepository extends MongoRepository<Vegetarian,String>{
    /**
     * 
     * @param reference
     * @return 
     */
    public Optional <Vegetarian> findByReference(String reference);
 
    /**
     * 
     * @param reference 
     */
    public void deleteByReference (String reference);
    
}
