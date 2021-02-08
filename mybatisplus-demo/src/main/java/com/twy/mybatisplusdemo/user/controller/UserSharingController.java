package com.twy.mybatisplusdemo.user.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.twy.mybatisplusdemo.user.entity.User;
import com.twy.mybatisplusdemo.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author gongpeng
 * @date 2021/2/7 10:29
 */
@RestController
@RequestMapping("/sharing/user")
@AllArgsConstructor
public class UserSharingController {

    private final UserService userService;

    @PostMapping
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/page")
    public Page<User> findUserPage(Page page) {
        return userService.page(page);
    }

    @GetMapping("/pageByOrderId")
    public Page<User> findUserPageByOrderId(Page page) {
        return userService.page(page, Wrappers.<User>lambdaQuery().orderByDesc(User::getId));
    }

}
