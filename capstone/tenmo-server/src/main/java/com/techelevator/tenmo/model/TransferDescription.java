package com.techelevator.tenmo.model;

public class TransferDescription {

    private String description;
    private int descriptionId;

    public TransferDescription(String description, int descriptionId) {
        this.description = description;
        this.descriptionId = descriptionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }
}
