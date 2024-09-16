package com.commerce.service.impl;

import com.commerce.entity.Users;
import com.commerce.error.Errors;
import com.commerce.mapper.UserMapper;
import com.commerce.model.UserDto;
import com.commerce.repository.UserRepository;
import com.commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserDto userDto) {
        Users user = userMapper.toEntity(userDto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDto findUserName(String username) {
        return userRepository.findById(username)
                .map(userMapper::toDto)
                .orElseThrow(() -> new Errors("User not found"));
    }

    @Override
    public UserDto update(String username, UserDto userDto) {
        Users user = userRepository.findById(username)
                .orElseThrow(() -> new Errors("User not found"));

        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public void delete(String username) {
        userRepository.findById(username)
                .orElseThrow(() -> new Errors("User not found"));
        userRepository.deleteById(username);
    }
}
