package com.twy.mybatisplusdemo.user.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twy.mybatisplusdemo.user.entity.User;
import com.twy.mybatisplusdemo.user.mapper.UserMapper;
import com.twy.mybatisplusdemo.user.service.UserService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author twy
 * @since 2021-01-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @CachePut(value = "user", key = "#user.code", unless = "#result==null")
    public User updateByCode(User user) {
        boolean result = this.update(user, Wrappers.<User>lambdaQuery().eq(User::getCode, user.getCode()));
        return result ? user : null;
    }
}
