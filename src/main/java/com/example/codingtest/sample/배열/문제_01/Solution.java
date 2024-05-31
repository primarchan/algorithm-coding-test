package com.example.codingtest.sample.배열.문제_01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, -5, 2, 4, 3})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
        System.out.println(Arrays.toString(solution(new int[]{1, 6, 7})));
    }

    /* 오름차순 정렬 */
    public static int[] solution(int[] arr) {
        Arrays.sort(arr);

        return arr;
    }

    /* 내림차순 정렬 */
    public static int[] solution2(int[] arr) {
        // 1단계: int[] 배열을 IntStream으로 변환
        // IntStream.of(arr)는 int 배열로부터 스트림을 생성합니다.
        return IntStream.of(arr)
                // 2단계: 각 int 를 Integer 로 박싱
                // .boxed()는 IntStream 을 Stream<Integer>로 변환합니다.
                .boxed()
                // 3단계: 스트림을 역순(내림차순)으로 정렬
                // .sorted((a, b) -> b - a)는 요소들을 내림차순으로 정렬합니다.
                .sorted((a, b) -> b - a)
                // 4단계: 각 Integer 를 다시 int 로 언박싱
                // .mapToInt(x -> x.intValue())는 Stream<Integer>를 다시 IntStream 으로 변환합니다.
                .mapToInt(Integer::intValue)
                // 5단계: IntStream 을 int[] 배열로 변환
                // .toArray()는 요소들을 새 int 배열로 수집합니다.
                .toArray();
    }

}
