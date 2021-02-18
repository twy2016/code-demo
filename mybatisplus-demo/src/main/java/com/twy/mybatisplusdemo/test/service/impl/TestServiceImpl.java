package com.twy.mybatisplusdemo.test.service.impl;

import com.twy.mybatisplusdemo.test.entity.Test;
import com.twy.mybatisplusdemo.test.mapper.TestMapper;
import com.twy.mybatisplusdemo.test.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author twy
 * @since 2021-02-18
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
