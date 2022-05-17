package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.TransferStatus;
import org.springframework.stereotype.Component;

@Component
public class JDBCTransferStatusDAO implements TransferStatusDAO{

    //To do


    @Override
    public TransferStatus statusDescription(String description) {
        return null;
    }

    @Override
    public TransferStatus statusId(int statusId) {
        return null;
    }
}
