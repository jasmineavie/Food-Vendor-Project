package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Balance;
import com.techelevator.tenmo.model.UserAccount;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class UserAccountService implements UserAccountServ{

    private final AuthenticatedUser authenticatedUser;
    private RestTemplate restTemplate = new RestTemplate();
    private String baseUrl = "http://localhost:8080/";

    public UserAccountService(String url, AuthenticatedUser authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
        this.restTemplate = new RestTemplate();
        this.baseUrl = url;
    }

    @Override
    public BigDecimal getBalance() {
        Balance balance = null;
        balance = restTemplate.exchange(baseUrl + "balance", HttpMethod.GET, makeEntity(), Balance.class).getBody();

//        try {
//
//        }catch (RestClientException | NullPointerException e){
//            System.out.println("Something went wrong.");
//        }

        return balance.getBalance();
    }

    @Override
    public UserAccount getAccountWithUserId(AuthenticatedUser authenticatedUser, int userId) {
        return null;
    }

    @Override
    public UserAccount getAccountWithAccountId(AuthenticatedUser authenticatedUser, int accountId) {
        return null;
    }

    private HttpEntity makeEntity() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(authenticatedUser.getToken());
        HttpEntity entity = new HttpEntity(httpHeaders);
        return entity;
    }
}
