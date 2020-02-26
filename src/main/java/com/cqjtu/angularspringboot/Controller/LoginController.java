package com.cqjtu.angularspringboot.Controller;

import com.cqjtu.angularspringboot.Model.Message;
import com.cqjtu.angularspringboot.entity.User;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * 用户登录控制器
 *
 * @author: suwen
 * @time: 2020/1/30 6:58 下午
 */
@RestController
@RequestMapping("/login")
@Api(tags = "用户登录-控制器")
@Log4j2
public class LoginController {

  @Autowired private DefaultKaptcha defaultKaptcha;

  /**
   * 登录验证
   *
   * @param user 用户
   * @param request http 请求
   * @return: com.cqjtu.angularspringboot.Model.Message
   * @author: suwen
   * @time: 2020/2/3 1:26 下午
   */
  @ApiOperation(value = "登录验证", notes = "用户登录验证，登录后状态存在 session 中。")
  @PostMapping("/login")
  public Message login(@RequestBody User user, HttpServletRequest request) {
    log.info(request.getSession().getAttribute("teachernum"));
    log.info(user.getUserNo() + " : " + user.getUserPwd());
    Message msg = new Message();
    msg.setMsg("The member of " + user.getUserNo() + " has been logined: " + user.getUserPwd());
    return msg;
  }

  /**
   * 创建动态验证码
   *
   * @param request http 请求
   * @param response http 响应
   * @return
   * @author suwen
   * @date 2020/2/26 下午12:06
   */
  @ApiOperation(
      value = "创建动态验证码",
      notes = "客户端有登录时请求创建动态验证码，服务器将生成 4 位数字和字母的随机值，并存在 session 中等待验证。")
  @GetMapping("/createImageCode")
  public void createImageCode(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    byte[] captchaChallengeAsJpeg = null;
    ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
    try {
      // 生产验证码字符串并保存到session中
      String createText = defaultKaptcha.createText();
      request.getSession().setAttribute("imageCode", createText);
      // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
      BufferedImage challenge = defaultKaptcha.createImage(createText);
      ImageIO.write(challenge, "jpg", jpegOutputStream);
      log.info("createImageCode:{}" + request.getSession().getAttribute("imageCode"));
    } catch (IllegalArgumentException e) {
      response.sendError(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
    captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("image/jpeg");
    ServletOutputStream responseOutputStream = response.getOutputStream();
    responseOutputStream.write(captchaChallengeAsJpeg);
    responseOutputStream.flush();
    responseOutputStream.close();
  }
}
