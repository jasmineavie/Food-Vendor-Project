package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.TransferDescription;

public interface TransferDescriptionDAO {

    TransferDescription description(String description);
    TransferDescription descriptionId(int transferDescriptionId);
}
