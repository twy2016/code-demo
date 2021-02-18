package com.twy.mybatisplusdemo.test.controller;


import com.twy.mybatisplusdemo.test.entity.Test;
import com.twy.mybatisplusdemo.test.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author twy
 * @since 2021-02-18
 */
@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping
    public boolean save(@RequestBody Test test) {
        return testService.save(test);
    }
}
