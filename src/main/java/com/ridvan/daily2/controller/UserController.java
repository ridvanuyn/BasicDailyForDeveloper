package com.ridvan.daily2.controller;

import com.ridvan.daily2.model.User;
import com.ridvan.daily2.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            String password = user.getPassword();
            user.setPassword(password);
            userService.saveUser(user);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().build();
    }

}
