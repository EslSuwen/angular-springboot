package com.cqjtu.angularspringboot.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * 标明是Entity，以被jpa识别为数据，映射到MySQL数据库。必须与@Id注解 结合使用
 *
 * @author: suwen
 * @time: 2020/1/31 6:01 下午
 */
@ApiModel(description = "测试数据实体")
@Entity
@Data
public class Demodata {

  /**
   * 标注表的唯一标识 标注表的该列，为自动生成数据
   *
   * @author: suwen
   * @time: 2020/1/31 6:01 下午
   */
  @ApiModelProperty(position = 0, value = "数据编号[添加操作可不传递,修改必传]")
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private Integer id;

  @ApiModelProperty(position = 1, value = "姓名", required = true)
  private String name;

  @ApiModelProperty(position = 2, value = "身高", required = true)
  private Integer height;

  @ApiModelProperty(position = 3, value = "消息")
  @Transient
  private Message message;

  @ApiModelProperty(position = 4, value = "列表数据")
  @Transient
  private List<String> stringList;
}
