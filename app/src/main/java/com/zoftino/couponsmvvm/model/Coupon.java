package com.zoftino.couponsmvvm.model;

public class Coupon {

    private String store;
    private String offer;
    private String expiry;

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String toString(){
        return store+" "+offer+" expires on "+expiry;
    }
}
