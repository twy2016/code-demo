package com.twy.entity;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gongpeng
 * @date 2020/11/13 22:01
 */
@Slf4j
public class ResultCode {

    private ResultCode() {

    }

    public static final Integer SUCCESS = 0;

    public static final Integer ERROR = -1;

}
