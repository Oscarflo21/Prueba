package com.cuatroa.retouno.service;

import com.cuatroa.retouno.model.User;
import com.cuatroa.retouno.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import static org.hibernate.criterion.Projections.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Oscar Florez Forero
 */
@Service
public class UserServices {

    @Autowired
    private UserRepository repository;
    /**
     * 
     * @return 
     */
    
    public List<User> getAll() {
        return repository.getAll();
    }
    
    public User save(User user){
        if(user.getName()==null || user.getEmail()==null || user.getPassword()==null || user.getIdentification()==null || user.getType()==null){ 
                return user;
        }else{
            List<User> existUser = repository.getUsersByNameOrEmail(user.getName(),user.getEmail());
            if(existUser.isEmpty()){
                if(user.getId()==null){
                    return repository.save(user);    
                }else{
                    Optional<User> existUser2 = repository.getUserById(user.getId());
                    if (existUser2.isEmpty() ){
                        return repository.save(user);
                    }else{
                        return user;
                    }
                }
            }else{
                return user;
            }
        }
    }
    
    /**
     * 
     * @param email
     * @return 
     */
    public boolean getuserByEmail(String email){
        return repository.getUserByEmail(email).isPresent();
    }
    
    public User getByEmailPass(String email, String password) {
        Optional<User> userExist = repository.getUserByEmailAndPassword(email, password);
        if (userExist.isPresent()) {
            return userExist.get();
        }else{
            return new User();
        }
    }
    /**
     * 
     * @param user
     * @return 
     */
    
    public User update(User user){
        if(user.getId()!=null){
            Optional<User> userExist = repository.getUserById(user.getId());
            if(userExist.isPresent()){
                if(user.getIdentification()!=null){
                    userExist.get().setIdentification(user.getIdentification());
                }
                if(user.getName()!=null){
                    userExist.get().setName(user.getName());
                }
                if(user.getBirthtDay()!=null){
                    userExist.get().setBirthtDay(user.getBirthtDay());
                }
                if(user.getMonthBirthtDay()!=null){
                    userExist.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if(user.getAddress()!=null){
                    userExist.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone()!=null){
                    userExist.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!=null){
                    userExist.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    userExist.get().setPassword(user.getPassword());
                }
                if(user.getZone()!=null){
                    userExist.get().setZone(user.getZone());
                }
                if(user.getType()!=null){
                    userExist.get().setType(user.getType());
                }
                return repository.save(userExist.get());
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public boolean deleteById(Integer id){
        Boolean aBoolean = repository.getUserById(id).map(user ->{
            repository.deleteById(id);
            return true;
        }).orElse(false);
            return aBoolean;
    }
 } 