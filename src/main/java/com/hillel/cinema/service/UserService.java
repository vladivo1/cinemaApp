package com.hillel.cinema.service;

import com.hillel.cinema.domain.Role;
import com.hillel.cinema.domain.User;
import com.hillel.cinema.repository.RoleRepository;
import com.hillel.cinema.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import javax.transaction.Transactional;


@Service @Transactional @Slf4j @RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id)  {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id  " + id + " не найден"));
    }

    public User getUserByEmail (String email) {
        return userRepository.findClientByEmail(email);

    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public User getUserByNumber (String phoneNumber) {
        return userRepository.findClientByPhoneNumber(phoneNumber);
    }

    public User updateUserById (Long id, User user) {
        return userRepository.findById(id)
                .map(entity -> {

                        entity.setFirstName(user.getFirstName());
                        entity.setLastName(user.getLastName());
                        entity.setEmail(user.getEmail());
                        entity.setDateOfBirth(user.getDateOfBirth());
                        entity.setCartNumber(user.getCartNumber());
                        entity.setPhoneNumber(user.getPhoneNumber());
                        return userRepository.save(entity);
                    })
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id " + id +  " не найден"));

    }

    public void deleteUser (Long id) {
         userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);

        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getName()));});
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

}
