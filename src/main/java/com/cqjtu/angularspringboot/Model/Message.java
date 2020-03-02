package com.cqjtu.angularspringboot.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Message 类不需要往数据库里存放，不用标识为@Entity。只需建立数据模型类即可
 *
 * @author: suwen
 * @time: 2020/1/31 6:02 下午
 */
@ApiModel(description = "消息实体")
public class Message {

  @ApiModelProperty(value = "消息", position = 0, required = true)
  private String msg;

  public Message() {}

  public Message(String msg) {
    this.msg = msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }
}
