package com.example.IWasHere.service;

import com.example.IWasHere.data.entity.Note;
import com.example.IWasHere.data.entity.User;
import com.example.IWasHere.data.repository.UserRepository;
import com.example.IWasHere.dto.NoteDTO;
import com.example.IWasHere.dto.UserDTO;
import com.example.IWasHere.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    private UserRepository userRepository;

    @Override
    public void createUser(UserDTO user) {
        User userDB = userMapper.userDTOToUser(user);
        userDB.setCreationDate(LocalDateTime.now());
        userRepository.save(userDB);
    }
}
