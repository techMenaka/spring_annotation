package com.spring.cmd;

import com.spring.cmd.User;
import com.spring.cmd.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by techMenaka on 3/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Validator validator;

    @Test
    public void shouldValidateDuplicatedLogin() throws Exception {
        // given
        String login = "ted@spring.com";
        User predefinedUser = new User(login, "pass".toCharArray());
        userRepository.save(predefinedUser);
        // when
        User newUser = new User(login, "pass".toCharArray());
        Set<ConstraintViolation<User>> violations = validator.validate(newUser);
        // then
        assertEquals(1, violations.size());
    }

}