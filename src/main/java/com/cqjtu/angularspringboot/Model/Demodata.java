package com.cqjtu.angularspringboot.Model;

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
@Entity
@Data
public class Demodata {

  /**
   * 标注表的唯一标识 标注表的该列，为自动生成数据
   *
   * @author: suwen
   * @time: 2020/1/31 6:01 下午
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private Integer id;

  private String name;
  private Integer height;
  @Transient private Message message;
  @Transient private List<String> stringList;
}
