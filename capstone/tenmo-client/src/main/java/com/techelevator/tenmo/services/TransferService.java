package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;

public interface TransferService {

    public void createTransfer(AuthenticatedUser authenticatedUser, Transfer transfer);
    public Transfer[] allTransfers(AuthenticatedUser authenticatedUser);
    public Transfer[] pendingTransferByUserId(AuthenticatedUser authenticatedUser);
    public Transfer[] transferFromUserId(AuthenticatedUser authenticatedUser, int userId);
    public Transfer transferFromTransferId(AuthenticatedUser authenticatedUser, int id);
    public void transferUpdate(AuthenticatedUser authenticatedUser, Transfer transfer);


}
