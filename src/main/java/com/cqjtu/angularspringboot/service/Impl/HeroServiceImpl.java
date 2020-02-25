package com.cqjtu.angularspringboot.service.impl;

import com.cqjtu.angularspringboot.entity.Hero;
import com.cqjtu.angularspringboot.mapper.HeroMapper;
import com.cqjtu.angularspringboot.service.HeroService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author suwen
 * @since 2020-02-24
 */
@Service
public class HeroServiceImpl extends ServiceImpl<HeroMapper, Hero> implements HeroService {

}
