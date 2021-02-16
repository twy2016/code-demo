package com.twy.mybatisplusdemo.user.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.twy.mybatisplusdemo.user.entity.User;
import com.twy.mybatisplusdemo.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/list")
    public List<User> findUserList() {
        return userService.list();
    }

    @GetMapping("/page")
    public Page<User> findUserPage(Page page) {
        return userService.page(page);
    }

    @GetMapping("/pageByOrderId")
    public Page<User> findUserPageByOrderId(Page page) {
        return userService.page(page, Wrappers.<User>lambdaQuery().orderByDesc(User::getId));
    }

    @GetMapping("/listByTime")
    public List<User> findUserListByTime(@RequestParam("startTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startTime,
                                         @RequestParam("endTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endTime) {
        return userService.list(Wrappers.<User>lambdaQuery().between(User::getCreateTime, startTime, endTime));
    }

    @PostMapping("/listByCode")
    public List<User> findUserListByTime(@RequestBody String[] codes) {
        return userService.list(Wrappers.<User>lambdaQuery().in(User::getCode, codes));
    }

}
