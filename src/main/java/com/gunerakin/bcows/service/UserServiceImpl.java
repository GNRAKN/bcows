package com.gunerakin.bcows.service;

import com.gunerakin.bcows.dto.UserDTO;
import com.gunerakin.bcows.mapper.BCOWSMapper;
import com.gunerakin.bcows.model.User;
import com.gunerakin.bcows.repository.UserRepository;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    BCOWSMapper bcowsMapper;

    @Override
    @Transactional(timeout = 10)
    public User saveUser(UserDTO userDTO) {
        Long existId = this.findExistUserId(userDTO.getUserName());
        User user = bcowsMapper.userDtoToUser(userDTO);
        user.setUserId(existId);
        return userRepository.save(user);
    }

    @Override
    @Transactional(timeout = 10, readOnly = true)
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    // @Transactional(timeout = 10)
    public boolean deleteUser(Long id) {
        try {
            Optional<User> user = userRepository.findById(id);
            userRepository.delete(user.get());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    @Transactional(timeout = 10, readOnly = true)
    public Optional<User> getUserByID(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Long findExistUserId(String userName){
        return userRepository.findExistUserId(userName);
    }

}
