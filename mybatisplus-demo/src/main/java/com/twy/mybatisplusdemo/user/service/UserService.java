package com.twy.mybatisplusdemo.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.twy.mybatisplusdemo.user.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author twy
 * @since 2021-01-28
 */
public interface UserService extends IService<User> {

    User updateByCode(User user);
}
