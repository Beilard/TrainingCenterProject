package com.study.epamproject.service;

import com.study.epamproject.domain.user.Client;

public interface ClientService<E> {
    Client login(String email, String password);
    E register(E e);
    E order();
}
