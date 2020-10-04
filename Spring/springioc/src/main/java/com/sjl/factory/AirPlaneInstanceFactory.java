package com.sjl.factory;

import com.sjl.bean.AirPlane;

/**
 * 实例工厂
 * @author Administrator
 */
public class AirPlaneInstanceFactory {

    public  AirPlane createAirplane(String jzName){
        System.out.println("实例工厂正在工作。。。");
        AirPlane plane = new AirPlane();
        plane.setFdj("太行");
        plane.setJzName(jzName);
        plane.setPersonNum(300);
        plane.setYc("195.98m");
        return plane;
    }
}
