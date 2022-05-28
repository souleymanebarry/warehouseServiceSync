package com.barry.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Warehouse {
    @Id
    private String code;
    private String city;
    private String address;
    private String flagTrt;
    private Integer zipCode;

    private String handle;


    public Warehouse() {
    }

    public Warehouse(String code, String city, String address, String flagTrt, Integer zipCode, String handle) {
        this.code = code;
        this.city = city;
        this.address = address;
        this.flagTrt = flagTrt;
        this.zipCode = zipCode;
        this.handle = handle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFlagTrt() {
        return flagTrt;
    }

    public void setFlagTrt(String flagTrt) {
        this.flagTrt = flagTrt;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }
}
