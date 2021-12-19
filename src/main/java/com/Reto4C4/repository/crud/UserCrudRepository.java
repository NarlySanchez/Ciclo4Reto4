package com.Reto4C4.repository.crud;

import com.Reto4C4.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

/**
 *
 * @author nbsc1
 * Reto 4 Ciclo 4
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {

    /**
     * en sql es asi
     *
     * @select * from user where user_email=""
     *
     */
    public Optional<User> findByEmail(String Email);

    /**
     * en sql es asi
     *
     * @param email
     * @param password
     * @return
     */

    public Optional<User> findByEmailAndPassword(String email, String password);

    /**
     *
     * Para seleccionar el usuario con el id maximo
     */
    Optional<User> findTopByOrderByIdDesc();
}
