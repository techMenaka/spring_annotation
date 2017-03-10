package com.spring.cmd;

import com.spring.cmd.annotation.UniqueLogin;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by techMenaka on 3/9/17.
 */
public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {
    private UserRepository userRepository;

    public UniqueLoginValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initialize(UniqueLogin constraint) {
        System.err.println(constraint.value());
    }

    public boolean isValid(String login, ConstraintValidatorContext context) {
        return login != null && !userRepository.findByLogin(login).isPresent();
    }

}
