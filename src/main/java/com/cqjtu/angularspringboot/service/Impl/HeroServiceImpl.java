package com.cqjtu.angularspringboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.angularspringboot.entity.Hero;
import com.cqjtu.angularspringboot.mapper.HeroMapper;
import com.cqjtu.angularspringboot.service.HeroService;
import org.springframework.stereotype.Service;

/**
 * 英雄服务实现类
 *
 * @author suwen
 * @since 2020-02-24
 */
@Service
public class HeroServiceImpl extends ServiceImpl<HeroMapper, Hero> implements HeroService {}
