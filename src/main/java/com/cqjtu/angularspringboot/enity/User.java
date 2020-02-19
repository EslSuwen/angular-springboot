package com.cqjtu.angularspringboot.enity;

import lombok.Data;

/**
 * 用户
 *
 * @author: suwen
 * @time: 2020/2/3 2:01 下午
 */
@Data
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
