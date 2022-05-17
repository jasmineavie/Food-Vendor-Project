package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.TransferDescription;
import org.springframework.stereotype.Component;

@Component
public class JDBCTransferDescriptionDAO implements TransferDescriptionDAO{


    //TO do
    @Override
    public TransferDescription description(String description) {
        return null;
    }

    @Override
    public TransferDescription descriptionId(int transferDescriptionId) {
        return null;
    }
}
