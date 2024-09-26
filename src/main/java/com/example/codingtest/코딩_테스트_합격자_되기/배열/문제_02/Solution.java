package com.example.codingtest.코딩_테스트_합격자_되기.배열.문제_02;

import java.util.Arrays;
import java.util.Collections;

/**
 * 배열 제어하기
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/02.java
 *
 * 정수 배열을 하나 받습니다. 배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하는 solution() 함수를 구현하세요.
 *
 * 제약 조건
 * 배열의 길이는 2 이상 1,000 이하입니다.
 * 각 배열의 데이터 값은 -100,000 이상 100,000 이하입니다.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 2, 2, 1, 3, 4})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
    }

    /**
     * Arrays.stream(arr)는 IntStream 을 생성합니다.
     * .boxed()는 Stream<Integer>로 변환합니다.
     * .distinct()는 중복을 제거한 Stream<Integer>를 반환합니다.
     * .sorted(Collections.reverseOrder())는 내림차순으로 정렬된 Stream<Integer>를 반환합니다.
     * .mapToInt(Integer::intValue)는 다시 IntStream 으로 변환합니다.
     * .toArray()는 IntStream 을 int[] 배열로 변환하여 반환합니다.
     */
    public static int[] solution(int[] arr) {

        return Arrays.stream(arr)
                .boxed()
                .distinct()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
