package com.producer.service.impl;

import com.producer.exception.DuplicateUserException;
import com.producer.model.User;
import com.producer.model.UserDto;
import com.producer.repository.UserRepository;
import com.producer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    @Lazy
    private BCryptPasswordEncoder bcryptEncoder;


    @Override
    public User save(UserDto dto) throws DuplicateUserException, NullPointerException {

        if(userRepository.findByEmail(dto.getEmail()) != null){
            throw new DuplicateUserException("User with this email already is exist");
        }

        if(dto.getId() == null){
            throw new NullPointerException("Id cannot be null");
        }
        if (dto.getName() == null) {
            throw new NullPointerException("Name cannot be null");
        }
        if(dto.getPassword() == null){
            throw new NullPointerException("Password cannot be null");
        }
        if(dto.getEmail() == null){
            throw new NullPointerException("Email cannot be null");
        }

        User nUser = dto.getUserFromDto();
        nUser.setPassword(bcryptEncoder.encode(dto.getPassword()));

        return userRepository.save(nUser);

    }


}
