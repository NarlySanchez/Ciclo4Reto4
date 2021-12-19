package com.Reto4C4.web;

import com.Reto4C4.model.Order;
import com.Reto4C4.model.User;
import com.Reto4C4.service.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author nbsc1 
 * Reto 4 Ciclo 4
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("user")

public class UserWeb {

    @Autowired
    private UserApi userService;

    /**
     *consultar
     * @return
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    
     @GetMapping("/{id}")
    public Optional <User> getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    /**
     * Crear o guardar
     * @param user
     * @return
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * Consultar
     * @param email
     * @return
     */
    @GetMapping("/emailexist/{email}")
    public boolean existEmail(@PathVariable("email") String email) {
        return userService.getUserByEmail(email);
    }

    /**
     * Consular
     * @param email
     * @param password
     * @return
     */
   @GetMapping("/{email}/{password}")
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.authenticateUser(email, password);
    }

    /**
     * *
     *Actualizar
     * @param user
     * @return
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     * Eliminar
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return userService.deleteById(id);
    }
}
