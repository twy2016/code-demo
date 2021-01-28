package com.twy.mybatisplusdemo.user.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.twy.mybatisplusdemo.user.entity.User;
import com.twy.mybatisplusdemo.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author twy
 * @since 2021-01-28
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{code}")
    @Cacheable(value = "user", key = "#code", unless = "#result==null")
    public User getById(@PathVariable String code) {
        return userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getCode, code));
    }

    @PostMapping
    public User saveOrUpdate(@RequestBody User user) {
        User one = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getCode, user.getCode()));
        if (one != null) {
            userService.updateByCode(user);
        } else {
            userService.save(user);
        }
        return user;
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.updateByCode(user);
    }

    @DeleteMapping("/{code}")
    @CacheEvict(value = "user", key = "#code")
    public boolean delete(@PathVariable String code) {
        return userService.remove(Wrappers.<User>lambdaQuery().eq(User::getCode, code));
    }

}
