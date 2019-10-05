package com.study.epamproject.service;

import com.study.epamproject.domain.members.User;

public interface UserService<E> {
    User login(String email, String password);
    E register(E e);
}
