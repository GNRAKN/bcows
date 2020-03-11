package com.gunerakin.bcows.controller;

import com.gunerakin.bcows.dto.UserDTO;
import com.gunerakin.bcows.mapper.BCOWSMapper;
import com.gunerakin.bcows.model.User;
import com.gunerakin.bcows.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    BCOWSMapper bcowsMapper;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO) {
        User savedUser = userService.saveUser(userDTO);
        return savedUser != null ?
                new ResponseEntity(savedUser, HttpStatus.OK) :
                new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAllUsers() {
        List<User> users = userService.getUsers();
        return users.size() > 0 ?
                new ResponseEntity(users, HttpStatus.OK) :
                new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteUser(@PathVariable(value = "id") Long id) {
        return userService.deleteUser(id) == true ?
                new ResponseEntity(true, HttpStatus.OK) :
                new ResponseEntity(false, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
