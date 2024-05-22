package com.project.monamichauffeurbackend.controller;

import com.project.monamichauffeurbackend.entity.User;
import com.project.monamichauffeurbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.project.monamichauffeurbackend.repository.UserRepository;

@RestController

@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null) {
            return "Email déjà enregistré";
        }
        userService.saveUser(user);
        return "Utilisateur enregistré avec succès";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())){
            return "Connexion réussie";
        } else {
            return "Informations d'identification invalides";
        }
    }
}
