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
}
