package com.twy.test.returntest;

/**
 * @author gongpeng
 * @date 2021/2/19 20:55
 */
public class ReturnTest {

    public static void main(String[] args) {
        System.out.println("返回结果：" + method1());
        System.out.println("返回结果：" + method2());
        System.out.println("返回结果：" + method3());
    }

    /**
     * finally有return
     *
     * @return
     */
    public static int method1() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            System.out.println("catch方法");
            return 1;
        } finally {
            System.out.println("finally方法");
            return 2;
        }
    }

    public static Test method2() {
        Test test = new Test(1, "aaa");
        try {
            return test;
        } catch (Exception e) {
            System.out.println("catch方法");
            test.setId(2);
            return test;
        } finally {
            System.out.println("finally方法");
            test.setId(3);
            test.setName("ccc");
        }
    }

    public static String method3() {
        String str = "aaa";
        try {
            str = str + "111";
            return str;
        } catch (Exception e) {
            System.out.println("catch方法");
            str = str + "222";
            return str;
        } finally {
            System.out.println("finally方法");
            str = str + "333";
        }
    }
}
