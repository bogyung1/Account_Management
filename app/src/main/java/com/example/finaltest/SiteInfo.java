package com.example.finaltest;

public class SiteInfo {

    String mName="";
    String mUrl="";
    String mUser="";
    String mPassword;
    public SiteInfo(String name, String url, String user, String password){
        this.mName=name;
        this.mUrl=url;
        this.mUser=user;
        this.mPassword=password;
    }
    public String getmName(){
        return this.mName;
    }
    public String getmUrl(){
        return this.mUrl;
    }
    public String getmUser(){
        return this.mUser;
    }
    public String getmPassword(){
        return this.mPassword;
    }

}
