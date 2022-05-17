package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserAccountDAO;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Balance;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
public class UserAccountController {

    @Autowired
    private UserAccountDAO userAccountDAO;
    @Autowired
    private UserDao userDao;

    public UserAccountController(UserAccountDAO userAccountDAO, UserDao userDao){
        this.userAccountDAO = userAccountDAO;
        this.userDao = userDao;
    }
    @RequestMapping(path = "/balance", method = RequestMethod.GET)
    public Balance getBalance(Principal principal){
        System.out.println(principal.getName());
        return userAccountDAO.getBalance(principal.getName());
    }

    @RequestMapping(path = "listOfUsers", method = RequestMethod.GET)
    public List <User> listOfUsers(){
        List <User> users = userDao.findAll();
        return users;
    }

}
