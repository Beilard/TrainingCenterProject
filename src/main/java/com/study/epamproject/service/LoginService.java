package com.study.epamproject.service;

import com.study.epamproject.domain.user.Client;

import java.util.Optional;

public interface LoginService {
    Optional<Client> login(String email, String password);
}
