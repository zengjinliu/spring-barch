package com.kiway.spring.swagger.springswagger.util;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author LiuZj
 * @date 2019/10/25 16:10
 */
public class SplitUtil {

    public static <T> List<List<T>> split(final List<T> origin, final int size) {
        if (CollectionUtils.isEmpty(origin)) {
            return Collections.emptyList();
        }
        int block = (origin.size() + size - 1) / size;
        return IntStream.range(0, block).
                boxed().map(i -> {
            int start = i * size;
            int end = Math.min(start + size, origin.size());
            return origin.subList(start, end);
        }).collect(Collectors.toList());
    }
}
