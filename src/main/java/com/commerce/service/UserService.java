package com.commerce.service;

import com.commerce.model.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto save(UserDto userDto);
    UserDto findUserName(String userName);
    UserDto update(String userName, UserDto userDto);
    void delete(String username);
}
