package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Balance;
import com.techelevator.tenmo.model.UserAccount;

import java.math.BigDecimal;

public interface UserAccountServ {

    BigDecimal getBalance();
    UserAccount getAccountWithUserId(AuthenticatedUser authenticatedUser, int userId);
    UserAccount getAccountWithAccountId(AuthenticatedUser authenticatedUser, int accountId);
}
