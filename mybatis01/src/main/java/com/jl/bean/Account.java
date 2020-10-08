package com.jl.bean;

import java.io.Serializable;

public class Account implements Serializable {
  /**
   * id
   */
  private long id;
  /**
   * 用户表id
   */
  private long uid;
  /**
   * 金额
   */
  private double money;
  /**
   * 一对一关系
   *
   * 子表实体应包含主表实体的引用
   */
  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public double getMoney() {
    return money;
  }

  public void setMoney(double money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "Account{" +
            "id=" + id +
            ", uid=" + uid +
            ", money=" + money +
            ", user=" + user +
            '}';
  }
}
