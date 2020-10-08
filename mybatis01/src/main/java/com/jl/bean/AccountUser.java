package com.jl.bean;


public class AccountUser  extends Account
{

    private String username;
    private String addresss;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    @Override
    public String toString() {
        return super.toString()+"AccountUser{" +
                "username='" + username + '\'' +
                ", addresss='" + addresss + '\'' +
                '}';
    }
}
