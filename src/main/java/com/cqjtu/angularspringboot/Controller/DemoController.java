package com.cqjtu.angularspringboot.Controller;

import com.cqjtu.angularspringboot.Model.Demodata;
import com.cqjtu.angularspringboot.Model.DemodataRepository;
import com.cqjtu.angularspringboot.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 标明是controller的bean 允许跨域访问。前端端口为4200。server端口为1230
 *
 * @author: suwen
 * @time: 2020/1/31 5:56 下午
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/demo")
public class DemoController {

  /** 该注释告诉springboot，去帮助实现Repository接口。否则，抛空指针异常。 */
  @Autowired private DemodataRepository demodataRepository;

  /**
   * 增加数据 Springboot将返回的类，以JSON字符串形式输出。这里使用Message model建立json格式数据
   *
   * @param demodata
   * @return: com.cqjtu.angularspringboot.Model.Message
   * @author: suwen
   * @time: 2020/1/31 5:58 下午
   */
  @PostMapping(value = "/newData")
  public Message addNewData(@RequestBody Demodata demodata) {
    System.out.println("addNewData()被调用");
    Message msg = new Message();
    // save后自动添加id
    demodataRepository.save(demodata);
    msg.setMsg(
        "The info of " + demodata.getName() + " has been added with the ID: " + demodata.getId());
    return msg;
  }

  /**
   * 获取数据 这里返回的是Iterable类型数据，为可迭代类型。可被循环访问
   *
   * @return: java.lang.Iterable<com.cqjtu.angularspringboot.Model.Demodata>
   * @author: suwen
   * @time: 2020/1/31 5:59 下午
   */
  @GetMapping(value = "/getData")
  public Iterable<Demodata> getDemodatas() {

    System.out.println("getDemodatas()被调用");

    return demodataRepository.findAll();
  }

  /**
   * 删除数据
   *
   * @return: com.cqjtu.angularspringboot.Model.Message
   * @author: suwen
   * @time: 2020/1/31 6:00 下午
   */
  @DeleteMapping(value = "/clearData")
  public Message clearDemodatas() {
    System.out.println("clearDemodatas()被调用");
    demodataRepository.deleteAll();
    Message msg = new Message();
    msg.setMsg("The database has been cleared");
    return msg;
  }
}
