package com.cqjtu.angularspringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.angularspringboot.entity.User;
import com.cqjtu.angularspringboot.mapper.UserMapper;
import com.cqjtu.angularspringboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author suwen
 * @since 2020-02-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {}
