package com.cqjtu.angularspringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

  @TableId(value = "user_no", type = IdType.AUTO)
  private Integer userNo;

  private String userPwd;

  private String userName;

  @TableField(exist = false)
  private List<Authority> authorities;
}
