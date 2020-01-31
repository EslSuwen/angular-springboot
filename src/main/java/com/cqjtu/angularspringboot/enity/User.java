package com.cqjtu.angularspringboot.enity;

/** @Author: suwen @Date: 2020/1/31 2:20 下午 */
public class User {
  private int id;
  private String name;
  private String pwd;
  private int tab;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public int getTab() {
    return tab;
  }

  public void setTab(int tab) {
    this.tab = tab;
  }
}
