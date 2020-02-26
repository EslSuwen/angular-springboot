package com.cqjtu.angularspringboot.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 验证请求返回模型
 *
 * @author suwen
 * @date 2020/2/26 下午12:19
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
  private String token;
}
