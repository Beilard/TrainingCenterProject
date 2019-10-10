package com.study.epamproject.service.implementation;

import com.study.epamproject.domain.user.UserCredential;
import com.study.epamproject.service.LoginService;
import com.study.epamproject.service.validator.Validator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    private final Validator<UserCredential> validator;

    public LoginServiceImpl(@Qualifier("loginValidator") Validator validator) {
        this.validator = validator;
    }

    @Override
    public boolean login(String email, String password) {
        validator.validate(new UserCredential(email, password));
        return true;
    }
}
