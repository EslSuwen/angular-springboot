package com.cqjtu.angularspringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 带验证 user 实体
 *
 * @author suwen
 * @since 2020-02-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_users")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "用户编号[添加操作可不传递,修改必传]", position = 0)
  @TableId(value = "user_no", type = IdType.AUTO)
  private Integer userNo;

  @ApiModelProperty(value = "用户密码", position = 1)
  private String userPwd;

  @ApiModelProperty(value = "用户名", position = 2)
  private String userName;

  @ApiModelProperty(value = "已验证用户列表", position = 3)
  @TableField(exist = false)
  private List<Authority> authorities;
}
