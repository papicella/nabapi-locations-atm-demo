package com.pivotal.nab.api.locations.demo.beans;

public class Atm
{
    private String description;
    private String address1;
    private String suburb;
    private String state;
    private String postcode;
    private Double latitude;
    private Double longitude;
    private String hours;

    public Atm ()
    {
    }

    public Atm(String description, String address1, String suburb, String state, String postcode, Double latitude, Double longitude, String hours) {
        this.description = description;
        this.address1 = address1;
        this.suburb = suburb;
        this.state = state;
        this.postcode = postcode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hours = hours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "description='" + description + '\'' +
                ", address1='" + address1 + '\'' +
                ", suburb='" + suburb + '\'' +
                ", state='" + state + '\'' +
                ", postcode='" + postcode + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", hours='" + hours + '\'' +
                '}';
    }
}
