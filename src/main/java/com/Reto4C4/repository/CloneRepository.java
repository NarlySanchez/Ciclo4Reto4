package com.Reto4C4.repository;

import com.Reto4C4.model.Clone;
import com.Reto4C4.repository.crud.CloneCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author nbsc1
 * Reto 4 Ciclo 4
 */
@Repository
public class CloneRepository {
   @Autowired
    private CloneCrudRepository repository; 
   
    public List<Clone> getAll() {
        return repository.findAll();
    }

    public Optional<Clone> getClones(Integer id) {
        return repository.findById(id);
    }
    public Clone save(Clone clone) {
        return repository.save(clone);
    }

    public void update(Clone clone) {
        repository.save(clone);
    }
    
    public void delete(Clone clone) {
        repository.delete(clone);
    } 
}
