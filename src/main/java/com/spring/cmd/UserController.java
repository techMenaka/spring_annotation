package com.spring.cmd;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by techMenaka on 3/9/17.
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
}
