package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.exception.RegisterException;
import com.thoughtworks.capacity.gtb.mvc.util.ErrorMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> userList = new ArrayList<>();

    public void register(User user) {
        if (userList.stream().anyMatch(registeredUser -> registeredUser.getUsername().equals(user.getUsername()))) {
            throw new RegisterException(ErrorMessage.USER_EXISTS);
        }
        user.setId(userList.size());
        userList.add(user);
    }
}
