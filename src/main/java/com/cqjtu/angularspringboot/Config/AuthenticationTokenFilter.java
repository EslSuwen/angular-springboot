package com.cqjtu.angularspringboot.Config;

import com.cqjtu.angularspringboot.util.JwtTokenUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AuthenticationTokenFilter 验证权限 token 过滤器
 *
 * @author suwen
 * @date 2020/2/24 下午1:42
 */
@Log4j2
public class AuthenticationTokenFilter extends OncePerRequestFilter {
  @Autowired private JwtTokenUtil jwtTokenUtil;

  @Autowired private SecurityProperties securityProperties;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain chain)
      throws ServletException, IOException {
    String authToken = request.getHeader(securityProperties.getJwt().getHeader());

    if (authToken != null && authToken.startsWith("Bearer ")) {
      authToken = authToken.substring(7);
    }
    UserDetails user = jwtTokenUtil.verify(authToken);
    log.info("user: " + user + "  URI: " + request.getRequestURI());

    if (user != null && SecurityContextHolder.getContext().getAuthentication() == null) {
      logger.info("checking authentication for user " + user.getUsername());
      UsernamePasswordAuthenticationToken authentication =
          new UsernamePasswordAuthenticationToken(user.getUsername(), "N/A", user.getAuthorities());
      authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    chain.doFilter(request, response);
  }
}
