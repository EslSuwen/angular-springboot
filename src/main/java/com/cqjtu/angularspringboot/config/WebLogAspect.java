package com.cqjtu.angularspringboot.config;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * WebLogAspect
 *
 * @author xiaoze
 * @date 2018/6/3
 *     <p>实现Web层的日志切面
 */
@Log4j2
@Aspect
@Component
public class WebLogAspect {

  ThreadLocal<Long> startTime = new ThreadLocal<Long>();

  /**
   * 定义一个切入点. 解释下：
   *
   * <p>~ 第一个 * 代表任意修饰符及任意返回值. ~ 第二个 * 任意包名 ~ 第三个 * 代表任意方法.
   *
   * <p>~ 第四个 * 定义在web包或者子包 ~ 第五个 * 任意方法 ~ .. 匹配任意数量的参数. execution(*
   * xiao.ze.demo.service.impl.*.*(..))
   */
  @Pointcut("execution(* com.cqjtu.angularspringboot.service.Impl.*.*(..))")
  public void webLog() {}

  @Before("webLog()")
  public void doBefore(JoinPoint joinPoint) {

    startTime.set(System.currentTimeMillis());

    // 接收到请求，记录请求内容
    log.info("WebLogAspect.doBefore()");
    ServletRequestAttributes attributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    // 记录下请求内容
    log.info("URL : " + request.getRequestURL().toString());
    log.info("HTTP_METHOD : " + request.getMethod());
    log.info("IP : " + request.getRemoteAddr());
    log.info(
        "CLASS_METHOD : "
            + joinPoint.getSignature().getDeclaringTypeName()
            + "."
            + joinPoint.getSignature().getName());
    log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    // 获取所有参数方法一：
    Enumeration<String> enu = request.getParameterNames();
    while (enu.hasMoreElements()) {
      String paraName = (String) enu.nextElement();
      System.out.println(paraName + ": " + request.getParameter(paraName));
    }
  }

  @AfterReturning("webLog()")
  public void doAfterReturning(JoinPoint joinPoint) {

    // 处理完请求，返回内容
    log.info("WebLogAspect.doAfterReturning()");
    log.info("耗时（毫秒） : " + (System.currentTimeMillis() - startTime.get()));
  }
}
