package com.cuatroa.retouno.model;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Oscar Florez Forero
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "vegetarians")
public class Vegetarian {
    @Id
    private String reference;
    private String brand;
    private String category;
    private String description;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;

    
}
