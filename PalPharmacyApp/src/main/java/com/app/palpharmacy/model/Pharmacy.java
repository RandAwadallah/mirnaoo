package com.app.palpharmacy.model;



public class Pharmacy {

    private String name;
    private String Description;
    private String vacation;
    private String region;
    private String opening;
    private String closing;
    private String phonenumer;
    private String image_url;
    private String city;
    private String longitude;
    private String latitude;

    public Pharmacy() {
    }




    public Pharmacy(String name, String description, String city , String opening, String region, String closing, String phone, String vacation,
                    String image_url, String longitude, String latitude) {
        this.name = name;
        Description = description;
        this.region = region;
        this.opening = opening;
        this.closing = closing;
        this.phonenumer = phone;
        this.image_url = image_url;
        this.city = city;
        this.vacation=vacation;
        this.longitude = longitude;
        this.latitude = latitude;

    }

    public String getVacation() {
        return vacation;
    }

    public void setVacation(String vacation) {
        this.vacation = vacation;
    }

    public String getLongitude() { return longitude; }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }



    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening=opening;
    }

    public String getClosing() {
        return closing;
    }

    public void setClosing(String closing) {
        this.closing = closing;
    }

    public String getPhonenumer() {
        return phonenumer;
    }

    public void setPhonenumer(String phonenumer) {
        this.phonenumer = phonenumer;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
