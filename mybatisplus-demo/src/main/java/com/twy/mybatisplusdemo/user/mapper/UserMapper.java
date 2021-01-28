package com.twy.mybatisplusdemo.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.twy.mybatisplusdemo.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author twy
 * @since 2021-01-28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
