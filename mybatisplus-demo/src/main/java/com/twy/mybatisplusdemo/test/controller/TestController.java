package com.twy.mybatisplusdemo.test.controller;


import com.twy.mybatisplusdemo.test.entity.Test;
import com.twy.mybatisplusdemo.test.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

    @PostMapping("save1")
    public boolean save1(@RequestBody Test test) {
        return testService.save(test);
    }

    @PostMapping("save2")
    public boolean save2(@RequestParam(required = false) String name, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime createTime) {
        Test test = new Test();
        test.setName(name);
        test.setCreateTime(createTime);
        return testService.save(test);
    }

    @GetMapping("save3")
    public boolean save3(Test test) {
        return testService.save(test);
    }
}
