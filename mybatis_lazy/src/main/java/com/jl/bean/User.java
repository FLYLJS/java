package com.jl.bean;


import java.util.List;

public class User {

  private long id;
  private String username;
  private long age;
  private String sex;
  private String address;

  private List<Long> ids;
  /**
   * 一对多关系映射，主表实体应该包含子表实体的引用
   */
  private List<Account> account;

  public List<Account> getAccount() {
    return account;
  }

  public void setAccount(List<Account> account) {
    this.account = account;
  }

  public List<Long> getIds() {
    return ids;
  }

  public void setIds(List<Long> ids) {
    this.ids = ids;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", age=" + age +
            ", sex='" + sex + '\'' +
            ", address='" + address + '\'' +
//            ", account=" + account +
            '}';
  }
}
