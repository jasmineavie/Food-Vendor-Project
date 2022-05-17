package com.techelevator.tenmo.model;

public class TransferStatus {

    private int statusId;
    private int statusDescription;

    public TransferStatus(int statusId, int statusDescription) {
        this.statusId = statusId;
        this.statusDescription = statusDescription;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(int statusDescription) {
        this.statusDescription = statusDescription;
    }
}
