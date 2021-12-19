package com.Reto4C4.model;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author nbsc1 Reto 4 Ciclo 4
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clone")
public class Clone {

    @Id
    private Integer id;
    private String brand;
    private String procesor;
    private String os;
    private String description;
    private String memory;
    private String hardDrive;
    private boolean availability = true;
    private double price;
    private int quantity;
    private String photography;

}
