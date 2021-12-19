package com.Reto4C4.web;

import com.Reto4C4.model.Clone;
import com.Reto4C4.model.Order;
import com.Reto4C4.model.User;
import com.Reto4C4.service.CloneApi;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author nbsc1 
 * Reto 4 Ciclo 4
 */
@RestController
@RequestMapping("/clone")
@CrossOrigin("*")
public class CloneWeb {

    @Autowired
    private CloneApi cloneService;

    @GetMapping("/all")
    public List<Clone> getAll() {
        return cloneService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Clone> getClones(@PathVariable("id") Integer id) {
        return cloneService.getClones(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone) {
        return cloneService.save(clone);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone update(@RequestBody Clone clone) {
        return cloneService.update(clone);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return cloneService.delete(id);
    }

}
