package com.cqjtu.angularspringboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * UserLombok 测试
 *
 * @author: suwen
 * @time: 2020/2/21 下午12:26
 */
@ApiModel(description = "UserLombok 测试")
@Data
public class UserLombok {
  @ApiModelProperty(value = "编号[添加操作可不传递,修改必传]", position = 0)
  private int id;

  @ApiModelProperty(value = "姓名", position = 1, required = true)
  private String name;

  @ApiModelProperty(value = "密码", position = 2, required = true)
  private String pwd;

  @ApiModelProperty(value = "权限[默认为学生]", position = 3)
  private int tab;
}
