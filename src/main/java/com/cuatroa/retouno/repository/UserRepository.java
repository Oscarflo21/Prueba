package com.cuatroa.retouno.repository;

import com.cuatroa.retouno.repository.crud.UserCrudRepository;
import com.cuatroa.retouno.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Oscar Florez Forero
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository repository;
    
    /**
     * 
     * @return 
     */

    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }
    
    /**
     * 
     * @param user
     * @return 
     */

    public User save(User user) {
        return repository.save(user);
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    public Optional<User> getUserByName(String name){
        return repository.findByName(name);
    }
    /**
     * 
     * @param email
     * @return 
     */
    public Optional<User> getUserByEmail(String email){
        return repository.findByEmail(email);
    }
   
    /**
     * 
     * @param name
     * @param email
     * @return 
     */
    public List<User> getUsersByNameOrEmail (String name, String email){
       return repository.findByNameOrEmail(name, email);
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public Optional<User> getUserByEmailAndPassword (String email, String password){
       return repository.findByEmailAndPassword(email,password);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<User> getUserById(Integer id){
        return repository.findById(id); 
    }
    
    /**
     * 
     * @param user 
     */
    public void delete(User user){
        repository.delete(user);
    }
    /**
     * 
     * @param id 
     */
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    /**
    public List<User> birthtDayList(String monthBirthtDay) {
        return repository.findByMonthBirthtDay(monthBirthtDay);
    }
    */
}
    