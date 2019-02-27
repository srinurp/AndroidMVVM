package com.zoftino.couponsmvvm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CouponData {
    private static Map<String, List<Coupon>> couponsByCat =
            new HashMap<String, List<Coupon>>();

    public static void loadCoupons(){
        addMobilesCoupons();
        addApplianceCoupons();
        addFashionCoupons();

        List<Coupon> coupons = new ArrayList<Coupon>();
        couponsByCat.put("sports", coupons);
        couponsByCat.put("travel", coupons);
        couponsByCat.put("furniture", coupons);
        couponsByCat.put("decor", coupons);
        couponsByCat.put("furnishing", coupons);
    }

    public static Map<String, List<Coupon>> getCoupons() {
        if(couponsByCat.isEmpty()){
            loadCoupons();
        }
       return couponsByCat;
    }

    public static void addMobilesCoupons(){
        List<Coupon> coupons = new ArrayList<Coupon>();

        Coupon coupon = new Coupon();
        coupon.setStore("Amazon");
        coupon.setOffer("Upto 20% off on Samsung mobiles");
        coupon.setExpiry("2018/12/30");

        coupons.add(coupon);

        coupon = new Coupon();
        coupon.setStore("BestBuy");
        coupon.setOffer("Upto 10% off on latest smart phonse");
        coupon.setExpiry("2018/12/04");

        coupons.add(coupon);

        couponsByCat.put("mobiles", coupons);
    }

    public static void addApplianceCoupons(){
        List<Coupon> coupons = new ArrayList<Coupon>();

        Coupon coupon = new Coupon();
        coupon.setStore("Amazon");
        coupon.setOffer("Upto 30% off on appliance");
        coupon.setExpiry("2018/12/30");

        coupons.add(coupon);

        coupon = new Coupon();
        coupon.setStore("Sears");
        coupon.setOffer("Flat $100 off on appliance");
        coupon.setExpiry("20181209");

        coupons.add(coupon);
        couponsByCat.put("appliance", coupons);
    }

    public static void addFashionCoupons(){
        List<Coupon> coupons = new ArrayList<Coupon>();

        Coupon coupon = new Coupon();
        coupon.setStore("Amazon");
        coupon.setOffer("Upto 80% off on fashion");
        coupon.setExpiry("2018/12/30");

        coupons.add(coupon);

        coupon = new Coupon();
        coupon.setStore("JCPenny");
        coupon.setOffer("Flat 40% off on branded fashion items");
        coupon.setExpiry("2018/12/20");

        coupons.add(coupon);

        coupon = new Coupon();
        coupon.setStore("Macys");
        coupon.setOffer("Minimum 30% off jeans");
        coupon.setExpiry("2018/12/24");

        coupons.add(coupon);

        coupon = new Coupon();
        coupon.setStore("Nordstrom");
        coupon.setOffer("Upto 30% off formal wear");
        coupon.setExpiry("2018/12/31");

        coupons.add(coupon);

        coupon = new Coupon();
        coupon.setStore("Khols");
        coupon.setOffer("Upto 80% off on kids wear");
        coupon.setExpiry("2018/12/26");

        coupons.add(coupon);

        couponsByCat.put("fashion", coupons);
    }
}
