package com.cqjtu.angularspringboot.Controller;

import com.cqjtu.angularspringboot.Model.Message;
import com.cqjtu.angularspringboot.enity.User;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/** @Author: suwen @Date: 2020/1/30 6:58 下午 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/login")
public class LoginController {

  @Autowired private DefaultKaptcha defaultKaptcha;

  @PostMapping("/toLogin")
  public Message toLogin(@RequestBody User user, HttpServletRequest request) {
    System.out.println(request.getSession().getAttribute("teachernum"));
    System.out.println(user.getId() + " : " + user.getPwd());
    Message msg = new Message();
    msg.setMsg("The member of " + user.getId() + " has been logined: " + user.getPwd());
    return msg;
  }

  @GetMapping("/Login")
  public Message loginTest() {
    Message msg = new Message();
    msg.setMsg("The member of " + 123 + " has been logined: " + 123);
    return msg;
  }

  @RequestMapping("/createImageCode")
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
      System.out.println("createImageCode:{}" + request.getSession().getAttribute("imageCode"));
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
