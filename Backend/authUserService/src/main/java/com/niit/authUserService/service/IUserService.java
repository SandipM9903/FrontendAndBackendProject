package com.niit.authUserService.service;

import com.niit.authUserService.model.User;

public interface IUserService
{
    public User addUser(User user);
    public User loginCheck(int userId, String password);
}
