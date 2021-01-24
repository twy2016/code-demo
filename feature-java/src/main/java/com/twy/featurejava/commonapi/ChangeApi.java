package com.twy.featurejava.commonapi;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * List转数组，数组转List
 *
 * @author gongpeng
 * @date 2021/1/18 22:46
 */
public class ChangeApi {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        String[] array = list.toArray(new String[0]);
        array[2] = "4";
        System.out.println(list);
        Arrays.stream(array).forEach(System.out::println);

        String[] strs = new String[]{"a", "b", "c", "d"};
        ArrayList<String> strList = CollUtil.toList(strs);
        strList.remove("a");
        System.out.println(strList);
        List<String> strings = Arrays.asList(strs);
        //使用asList移除元素会报错
//        strings.remove("a");
        System.out.println(strings);
        Arrays.stream(strs).forEach(System.out::println);

        String str = "a#b#c#";
        String[] strArr = str.split("#");
        ArrayList<String> stringArrayList = CollUtil.toList(strArr);
        String join = CollUtil.join(stringArrayList, ",");
        System.out.println(join);
    }
}
