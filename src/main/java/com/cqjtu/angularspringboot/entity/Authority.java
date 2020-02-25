package com.cqjtu.angularspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Authority
 *
 * @author suwen
 * @date 2020/2/24 下午1:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority {

  private Long id;

  private AuthorityName name;

  private List<User> users;
}
