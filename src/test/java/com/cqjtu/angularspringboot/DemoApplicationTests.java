package com.cqjtu.angularspringboot;

import com.cqjtu.angularspringboot.Model.Message;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Log4j2
class DemoApplicationTests {

  @Test
  void contextLoads() {}

  private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

  public static void main(String[] args) {
    for (int i = 0; i < 3; i++) {
      // 记录trace级别的信息
      logger.trace("log4j2日志输出：This is trace message.");
      // 记录debug级别的信息
      logger.debug("log4j2日志输出：This is debug message.");
      // 记录info级别的信息
      logger.info("log4j2日志输出：This is info message.");
      // 记录error级别的信息
      logger.error("log4j2日志输出：This is error message.");

      logger.error(new Message());

      Map<String, Object> map = new HashMap<>();
      map.put("string", "string");

      log.error(map);
    }
  }
}
