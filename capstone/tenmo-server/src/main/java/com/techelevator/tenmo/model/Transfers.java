package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transfers {

    public int toAccount;
    public int fromAccount;
    public int transferId;
    public int transferStatusId;
    public int transferDescriptionId;
    private BigDecimal amount;
    private String fromUser;
    private String toUser;
    private String transferStatus;

    public Transfers(int transferId, int transferDescriptionId, int statusId, int toAccount, int fromAccount, BigDecimal amount) {
        this.transferId = transferId;
        this.transferDescriptionId = transferDescriptionId;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.transferStatusId = statusId;
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getTransferId() {
        return transferId;
    }

    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    public int getTransferStatusId() {
        return transferStatusId;
    }

    public void setTransferStatusId(int transferStatusId) {
        this.transferStatusId = transferStatusId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public int getTransferDescriptionId() {
        return transferDescriptionId;
    }

    public void setTransferDescriptionId(int transferDescriptionId) {
        this.transferDescriptionId = transferDescriptionId;
    }
}
