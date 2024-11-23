package com.example.concertticket;

public class Disaster {
    private String disasterName;

    public String getDisasterName() {return disasterName;}

    public String getDisasterType() {return disasterType;}

    public void setNameDisaster(String nameDisaster) {this.disasterName = nameDisaster;}

    public void setDisasterType(String disasterType) {this.disasterType = disasterType;}

    private String disasterType;

    public Disaster(String nameDisaster, String disasterType) {
        this.disasterName = nameDisaster;
        this.disasterType = disasterType;
    }

    public String getNameDisaster() {
        return disasterName;
    }
}