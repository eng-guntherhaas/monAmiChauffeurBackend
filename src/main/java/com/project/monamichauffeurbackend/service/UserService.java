package com.project.monamichauffeurbackend.service;

import com.project.monamichauffeurbackend.entity.User;

public interface UserService {

    User findByEmail(String email);
    User saveUser(User user);
}
