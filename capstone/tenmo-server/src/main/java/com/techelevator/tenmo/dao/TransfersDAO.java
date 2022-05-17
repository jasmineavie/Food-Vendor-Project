package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfers;

import java.util.List;

public interface TransfersDAO {

    List<Transfers> allTransfers();
    List<Transfers> transfersByUserId(int userId);
    List<Transfers> pendingTransfers(int userId);
    public void createTransfer(Transfers transfers);
    public void changeTransfers(Transfers transfers);
    Transfers getTransfersByTransfersId(int transfersId);

}
