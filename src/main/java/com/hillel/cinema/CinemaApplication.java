package com.hillel.cinema;

import com.hillel.cinema.domain.Role;
import com.hillel.cinema.domain.User;
import com.hillel.cinema.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class CinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {

            userService.saveRole(new Role("ROLE_USER"));
            userService.saveRole(new Role("ROLE_ADMIN"));

            userService.saveUser(new User("Kostya", "Kostyan", "1234", "Shuryhin", "ksurygin5@gmail.com", null, "20202020", "0951427261",
                    new ArrayList<>()));
            userService.saveUser(new User("John", "John", "1234", "Travolta", "travolta5@gmail.com", null, "20202020", "0951427261",
                    new ArrayList<>()));

            userService.addRoleToUser("Kostyan", "ROLE_USER");
            userService.addRoleToUser("Kostyan", "ROLE_ADMIN");
            userService.addRoleToUser("John", "ROLE_USER");


        };
    }
}
