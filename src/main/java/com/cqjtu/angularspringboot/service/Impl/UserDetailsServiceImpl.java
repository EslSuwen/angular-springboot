package com.cqjtu.angularspringboot.service.Impl;

import com.cqjtu.angularspringboot.entity.Authority;
import com.cqjtu.angularspringboot.entity.AuthorityName;
import com.cqjtu.angularspringboot.entity.User;
import com.cqjtu.angularspringboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.cqjtu.angularspringboot.util.AuthorityUtil.createGrantedAuthorities;

/**
 * SpringBoot UserDetails 服务实现类
 *
 * @author suwen
 * @date 2020/2/26 下午12:20
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserMapper userMapper;

  @Autowired
  public UserDetailsServiceImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    User user = userMapper.selectById(username);
    List<Authority> authorities = new ArrayList<>();
    if (user.getUserTab() == 1) {
      authorities.add(new Authority(1L, AuthorityName.ROLE_ADMIN));
    } else {
      authorities.add(new Authority(1L, AuthorityName.ROLE_USER));
    }
    user.setAuthorities(authorities);
    return create(user);
  }

  private static org.springframework.security.core.userdetails.User create(User user) {
    return new org.springframework.security.core.userdetails.User(
        user.getUserName(), user.getUserPwd(), createGrantedAuthorities(user.getAuthorities()));
  }
}
