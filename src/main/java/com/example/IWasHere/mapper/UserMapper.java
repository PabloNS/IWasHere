package com.example.IWasHere.mapper;

import com.example.IWasHere.data.entity.User;
import com.example.IWasHere.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDto(User user);

    User userDTOToUser(UserDTO user);
}
