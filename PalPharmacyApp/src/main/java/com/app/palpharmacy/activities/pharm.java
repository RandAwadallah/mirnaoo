package com.app.palpharmacy.activities;

public class pharm {
    private String pharname;
    private String title;
    private String endtime;
    private int image;

    public pharm() {

    }


    public pharm(String pharname, String title, String endtime, int image) {
        this.pharname = pharname;
        this.title = title;
        this.endtime = endtime;
        this.image = image;
    }

    public String getPharname() {
        return pharname;
    }

    public void setPharname(String pharname) {
        this.pharname = pharname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
