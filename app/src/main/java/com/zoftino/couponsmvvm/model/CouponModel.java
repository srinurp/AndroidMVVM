package com.zoftino.couponsmvvm.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

public class CouponModel{

    private Map<String, List<Coupon>> couponsByCat;

    public CouponModel(){
        couponsByCat = CouponData.getCoupons();
    }
    public Observable<ArrayList<String>> getCategories(){
       return Observable.just(new ArrayList<String>(couponsByCat.keySet()));
    }
    public Observable<List<Coupon>> getCouponsByCat(String cat){
        return Observable.just(couponsByCat.get(cat));
    }
}
