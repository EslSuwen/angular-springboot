package com.cqjtu.angularspringboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Authority 已验证用户
 *
 * @author suwen
 * @date 2020/2/24 下午1:34
 */
@ApiModel(description = "已验证用户实体")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority {
  @ApiModelProperty(value = "编号", position = 0, required = true)
  private Long id;

  @ApiModelProperty(value = "权限", position = 1, required = true)
  private AuthorityName name;

  @ApiModelProperty(value = "已验证用户列表", position = 2, required = true)
  private List<User> users;
}
