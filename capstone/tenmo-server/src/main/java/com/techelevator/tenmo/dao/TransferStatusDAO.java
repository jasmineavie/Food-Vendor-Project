package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.TransferStatus;

public interface TransferStatusDAO {


    TransferStatus statusDescription(String description);
    TransferStatus statusId(int statusId);
}
