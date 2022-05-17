package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.User;

public interface UserServ {

    User[] getAllUsers(AuthenticatedUser authenticatedUser);
    User getUserById(AuthenticatedUser authenticatedUser, int userId);
}
