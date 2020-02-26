package com.cqjtu.angularspringboot.Model;

import lombok.Data;

/**
 * 验证请求接收模型
 * 
 * @author suwen
 * @date 2020/2/26 下午12:20
 */
@Data
public class AuthenticationRequest {
  private String username;

  private String password;
}
