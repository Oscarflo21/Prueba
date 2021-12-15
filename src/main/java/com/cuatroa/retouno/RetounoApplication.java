package com.cuatroa.retouno;

import com.cuatroa.retouno.repository.crud.UserCrudRepository;
import com.cuatroa.retouno.repository.crud.VegetarianCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RetounoApplication implements CommandLineRunner {
        
        @Autowired
        private VegetarianCrudRepository vegetariansRepository;
        
        @Autowired
        private UserCrudRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(RetounoApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        vegetariansRepository.deleteAll();
    }

}
