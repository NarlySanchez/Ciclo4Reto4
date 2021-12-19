package com.Reto4C4.repository;

import com.Reto4C4.model.User;
import com.Reto4C4.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author nbsc1
 * Reto 4 Ciclo 4
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     *
     * @return
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userCrudRepository.findById(id);
    }

    /**
     *
     * @param user
     * @return
     */
    public User save(User user) {
        return userCrudRepository.save(user);
    }

    public void update(User user) {
        userCrudRepository.save(user);
    }

    public void deleteById(Integer id) {
        userCrudRepository.deleteById(id);

    }

    /**
     *
     * @param email
     * @return
     */
    public boolean getUserByEmail(String email) {
        Optional<User> userExistEmail = userCrudRepository.findByEmail(email);

        return !userExistEmail.isEmpty();
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */

    public Optional<User>authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
     public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }

}
