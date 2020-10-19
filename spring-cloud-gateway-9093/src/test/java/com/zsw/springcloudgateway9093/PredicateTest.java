package com.zsw.springcloudgateway9093;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * 函数式接口 Predicate
 *
 * @author zhangshiwei
 * @since 2020年10月18日 下午4:12:53
 */
public class PredicateTest {

    @Test
    public void test1() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            list.add(i);
        }
        System.out.println(list);

        Predicate<Integer> predicate1 = i -> i > 10;
        Predicate<Integer> predicate2 = i -> i < 20;
        Predicate<Integer> predicate3 = i -> i % 2 == 0;

        System.out.println("predicate1过滤 : " + list.stream().filter(predicate1).collect(Collectors.toList()));

        System.out.println("predicate2过滤 : " + list.stream().filter(predicate2).collect(Collectors.toList()));

        System.out.println("predicate3过滤 : " + list.stream().filter(predicate3).collect(Collectors.toList()));

        System.out.println("三个过滤 : "
                + list.stream().filter(predicate1.and(predicate2).and(predicate3)).collect(Collectors.toList()));

    }
}
