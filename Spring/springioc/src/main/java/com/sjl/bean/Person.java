package com.sjl.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author Administrator
 */
public class Person {

    /**
     *     基本类型直接使用property
     *     <property name="age" value="13"/> 自动进行类型转换
     *     xml都是纯文本
     */
    private String username = "小丽";
    private String age;
    private String address;

    private Car car;
    private List<Book> books;
    private Map<String,Object> maps;
    private Properties properties;

    public Person() {
        System.out.println("person 无参构造");
    }

    public Person(String username, String age, String address) {
        this.username = username;
        this.age = age;
        this.address = address;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", car=" + car +
                ", books=" + books +
                ", maps=" + maps +
                ", properties=" + properties +
                '}';
    }
}
