package com.sjl.factory;

import com.sjl.bean.AirPlane;

/**
 * 静态工厂
 * @author Administrator
 */
public class AirPlaneStaticFactory {

    public static AirPlane createAirplane(String jzName){
        System.out.println("静态工厂正在工作。。。");
        AirPlane plane = new AirPlane();
        plane.setFdj("太行");
        plane.setJzName(jzName);
        plane.setPersonNum(300);
        plane.setYc("195.98m");
        return plane;
    }
}
