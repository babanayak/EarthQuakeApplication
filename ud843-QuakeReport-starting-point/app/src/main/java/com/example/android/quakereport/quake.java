package com.example.android.quakereport;

public class quake {
    private double magnitude;
    private long date;
    private String place;
    private String url;
    public quake(double magniutde,String place,long date,String url){
        this.magnitude=magniutde;
        this.date=date;
        this.place=place;
        this.url=url;
    }

  public double getmagnitude(){
        return magnitude;
  }
  public long getDate(){
        return date;
  }

    public String getPlace() {
        return place;
    }
    public String getUrl(){
        return url;
    }
}
