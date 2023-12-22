package com.producer.service;

import com.producer.exception.DuplicateUserException;
import com.producer.model.User;
import com.producer.model.UserDto;

public interface UserService {
    public User save(UserDto dto) throws DuplicateUserException, NullPointerException;

}
