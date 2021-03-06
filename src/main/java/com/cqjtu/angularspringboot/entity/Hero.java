package com.cqjtu.angularspringboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 测试 hero 实体
 *
 * @author suwen
 * @since 2020-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Hero implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "hero_no", type = IdType.AUTO)
  private Integer heroNo;

  private String heroName;

  private String createBy;

  private LocalDateTime createTime;

  private String lastModifiedBy;

  private LocalDateTime lastModifiedTime;
}
