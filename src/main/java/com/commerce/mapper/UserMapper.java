package com.commerce.mapper;


import com.commerce.entity.Users;
import com.commerce.model.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto toDto(Users user) {
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setRole(user.getRole());
        return dto;
    }

    public Users toEntity(UserDto userDto) {
        Users user = new Users();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        return user;
    }

    public List<UserDto> toDtoList(List<Users> userList) {
        return userList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<Users> toEntityList(List<UserDto> userDtoList) {
        return userDtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
