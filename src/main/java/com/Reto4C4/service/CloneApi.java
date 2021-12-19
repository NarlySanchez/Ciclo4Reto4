package com.Reto4C4.service;

import com.Reto4C4.model.Clone;
import com.Reto4C4.model.User;
import com.Reto4C4.repository.CloneRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author nbsc1
 * Reto 4 Ciclo 4
 */

@Service
public class CloneApi {

    @Autowired
    private CloneRepository repository;

    public List<Clone> getAll() {
        return repository.getAll();
    }

    public Optional<Clone> getClones(Integer id) {
        return repository.getClones(id);
    }

    public Clone save(Clone products) {
        if (products.getId() == null) {
            return products;
        } else {
            return repository.save(products);
        }
    }

    public Clone update(Clone products) {

        if (products.getId() != null) {
            Optional<Clone> productsDb = repository.getClones(products.getId());
            if (!productsDb.isEmpty()) {

                if (products.getBrand() != null) {
                    productsDb.get().setBrand(products.getBrand());
                }

                if (products.getProcesor() != null) {
                    productsDb.get().setProcesor(products.getProcesor());
                }
                if (products.getOs()!= null) {
                    productsDb.get().setOs(products.getOs());
                }
                if (products.getDescription() != null) {
                    productsDb.get().setDescription(products.getDescription());
                }
                if (products.getMemory() != null) {
                    productsDb.get().setMemory(products.getMemory());
                }
                if (products.getHardDrive() != null) {
                    productsDb.get().setHardDrive(products.getHardDrive());
                }
                if (products.getPrice() != 0.0) {
                    productsDb.get().setPrice(products.getPrice());
                }
                if (products.getQuantity() != 0) {
                    productsDb.get().setQuantity(products.getQuantity());
                }
                if (products.getPhotography() != null) {
                    productsDb.get().setPhotography(products.getPhotography());
                }
                productsDb.get().setAvailability(products.isAvailability());
                repository.update(productsDb.get());
                return productsDb.get();
            } else {
                return products;
            }
        } else {
            return products;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getClones(id).map(products -> {
            repository.delete(products);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
