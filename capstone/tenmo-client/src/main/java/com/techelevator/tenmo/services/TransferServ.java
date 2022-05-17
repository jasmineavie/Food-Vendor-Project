package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class TransferServ implements TransferService{

    private String baseUrl = "http://localhost:8080/";
    private RestTemplate restTemplate = new RestTemplate();

    public TransferServ(String BASE_URL) {
        this.baseUrl = BASE_URL;
    }

    @Override
    public void createTransfer(AuthenticatedUser authenticatedUser, Transfer transfer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authenticatedUser.getToken());
        HttpEntity<Transfer> entity = new HttpEntity<>(transfer,headers);

        String url = baseUrl + "transfer/" + transfer.getTransferId();

        try{
            restTemplate.exchange(url, HttpMethod.POST, entity, Transfer.class);
        }catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println();
        }

    }

    @Override
    public Transfer[] allTransfers(AuthenticatedUser authenticatedUser) {
        Transfer[] transfers = new Transfer[0];

        try{
            transfers = restTemplate.exchange(baseUrl + "transfer", HttpMethod.GET, entity(authenticatedUser), Transfer[].class).getBody();
        }catch (RestClientResponseException | ResourceAccessException e){
            System.out.println();
        }
        return transfers;
    }

    @Override
    public Transfer[] pendingTransferByUserId(AuthenticatedUser authenticatedUser) {
        Transfer[] transfers = null;
        try {
            transfers = restTemplate.exchange(baseUrl + "transfer/user/{id}" + authenticatedUser.getUser().getId() + "/pending", HttpMethod.GET, entity(authenticatedUser), Transfer[].class).getBody();
        }catch (RestClientResponseException | ResourceAccessException e){
            System.out.println();
        }
        return transfers;
    }

    @Override
    public Transfer[] transferFromUserId(AuthenticatedUser authenticatedUser, int userId) {
        Transfer[] transfers = null;
        try {
            transfers = restTemplate.exchange(baseUrl + "transfer/user/{id}" + authenticatedUser.getUser().getId(), HttpMethod.GET, entity(authenticatedUser), Transfer[].class).getBody();
        }catch (RestClientResponseException | ResourceAccessException e){
            System.out.println();
        }
        return transfers;
    }

    @Override
    public Transfer transferFromTransferId(AuthenticatedUser authenticatedUser, int id) {
        Transfer transfers = null;
        try {
            transfers = restTemplate.exchange(baseUrl + "transfer/" + id, HttpMethod.GET, entity(authenticatedUser), Transfer.class).getBody();
        }catch (RestClientResponseException | ResourceAccessException e){
            System.out.println();
        }
        return transfers;
    }

    @Override
    public void transferUpdate(AuthenticatedUser authenticatedUser, Transfer transfer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authenticatedUser.getToken());
        HttpEntity<Transfer> entity = new HttpEntity<>(transfer, headers);

        String url = baseUrl + "transfer/" + transfer.getTransferId();

        try {
            restTemplate.exchange(url, HttpMethod.GET, entity, Transfer.class);
        }catch (RestClientResponseException | ResourceAccessException e){
            System.out.println();
        }



    }
    private HttpEntity entity(AuthenticatedUser authenticatedUser){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authenticatedUser.getToken());
        HttpEntity entity = new HttpEntity(headers);
        return entity;
    }
}
