package com.twy.featurejava.streamapi;

import java.util.Optional;

/**
 * @author gongpeng
 * @date 2021/1/16 23:14
 */
public class OptionalApi {

    public static void main(String[] args) {
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a1 = Optional.ofNullable(value1);
        Optional<Integer> a2 = Optional.ofNullable(value2);
        System.out.println("第一个参数值存在: " + a1.isPresent());
        System.out.println("第一个参数值存在: " + a2.isPresent());
        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b2 = Optional.of(value2);
        Optional<Integer> b1 = Optional.of(value1);
        System.out.println("第二个参数值存在: " + b1.isPresent());
        System.out.println("第二个参数值存在: " + b2.isPresent());

        Integer result = Optional.ofNullable(value1).orElse(50);
        System.out.println("第一个参数为空则设置值:" + result);

        Integer result2 = Optional.ofNullable(value2).orElse(1);
        System.out.println("第一个参数为空则设置值:" + result2);
        Integer result3 = Optional.ofNullable(value2).orElseGet(OptionalApi::setNum);
        System.out.println("第一个参数为空则设置值:" + result3);

        Optional.ofNullable(value1).orElseThrow(NullPointerException::new);

    }

    private static Integer setNum() {
        System.out.println("设置值");
        return 100;
    }

}
