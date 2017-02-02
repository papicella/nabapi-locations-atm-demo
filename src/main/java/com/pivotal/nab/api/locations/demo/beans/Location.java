package com.pivotal.nab.api.locations.demo.beans;

public class Location
{
    private String apiStructType;
    private Atm atm;

    public Location()
    {
    }

    public Location(String apiStructType, Atm atm) {
        this.apiStructType = apiStructType;
        this.atm = atm;
    }

    public String getApiStructType() {
        return apiStructType;
    }

    public void setApiStructType(String apiStructType) {
        this.apiStructType = apiStructType;
    }

    public Atm getAtm() {
        return atm;
    }

    public void setAtm(Atm atm) {
        this.atm = atm;
    }

    @Override
    public String toString() {
        return "Location{" +
                "apiStructType='" + apiStructType + '\'' +
                ", atm=" + atm +
                '}';
    }
}
