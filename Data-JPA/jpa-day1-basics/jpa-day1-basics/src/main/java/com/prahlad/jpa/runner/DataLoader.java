package com.prahlad.jpa.runner;


import com.prahlad.jpa.entity.User;
import com.prahlad.jpa.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader 
{

    @Bean
    CommandLineRunner loadData(UserRepository userRepository) 
    {
        return args -> 
        {

            User u1 = new User();
            u1.setName("Rahul");
            u1.setEmail("rahul@gmail.com");

            User u2 = new User();
            u2.setName("Amit");
            u2.setEmail("amit@gmail.com");

            userRepository.save(u1);
            userRepository.save(u2);

            System.out.println("Sample users inserted");
        };
    }
}

