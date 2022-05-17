package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class UserService implements UserServ {

    private String baseUrl = "http://localhost:8080/";
    private RestTemplate restTemplate;

    public UserService(){
        this.restTemplate = new RestTemplate();
    }

    @Override
    public User[] getAllUsers(AuthenticatedUser authenticatedUser) {
        User[] users = null;
        users = restTemplate.exchange(baseUrl + "tenmo_user", HttpMethod.GET, makeEntity(authenticatedUser), User[].class).getBody();
        return users;
    }

    @Override
    public User getUserById(AuthenticatedUser authenticatedUser, int userId) {
        User user = null;
        user= restTemplate.exchange(baseUrl + "tenmo_user/" + userId, HttpMethod.GET, makeEntity(authenticatedUser), User.class).getBody();
        return user;
    }
    private HttpEntity makeEntity(AuthenticatedUser authenticatedUser) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(authenticatedUser.getToken());
        HttpEntity entity = new HttpEntity(httpHeaders);
        return entity;
}}
