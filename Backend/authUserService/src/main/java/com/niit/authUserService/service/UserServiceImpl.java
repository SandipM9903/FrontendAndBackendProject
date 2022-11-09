package com.niit.authUserService.service;

import com.niit.authUserService.model.User;
import com.niit.authUserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserRepository userRepository;


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User loginCheck(int userId, String password) {
        if(userRepository.findById(userId).isPresent())
        {
            User user=userRepository.findById(userId).get();
            if(user.getPassword().equals(password))
            {
                user.setPassword("");
                return user;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
}
