package com.priyanshu.userinfo.service;

import com.priyanshu.userinfo.dto.UserDTO;
import com.priyanshu.userinfo.entity.User;
import com.priyanshu.userinfo.mapper.UserMapper;
import com.priyanshu.userinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDTO addUser(UserDTO userDTO){
        User newUser = userRepository.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(newUser);
    }

    public ResponseEntity<UserDTO> fetchUserById(Integer userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user.get()), HttpStatus.FOUND);
        }
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
