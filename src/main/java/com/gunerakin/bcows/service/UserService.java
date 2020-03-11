package com.gunerakin.bcows.service;

import com.gunerakin.bcows.dto.UserDTO;
import com.gunerakin.bcows.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(UserDTO userDTO);

    List<User> getUsers();

    boolean deleteUser(Long user);

    Optional<User> getUserByID(Long userId);

    Long findExistUserId(String userName);

}
