package com.example.codingtest.sample.배열.문제_03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 두 개 뽑아서 더하기
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/03.java
 *
 * 정수 배열 numbers 가 주어집니다.
 * numbers 에서 서로 다른 인덱스에 있는 2개의 수를 뽑아 더해 만들 수 있는 모든 수를
 * 배열에 오름차순으로 담아 반환하는 solution() 함수를 완성하세요.
 *
 * 제약 조건
 * numbers 의 길이는 2 이상 100 이하입니다.
 * numbers 의 모든 수는 0 이상 100 이하입니다.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(solution(new int[]{5, 0, 2, 7})));
    }

    public static int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();  // 중복값을 제거하기 위해서 HashSet 생성

        // 두 수를 선택하는 모든 경우의 수를 반복문으로 구함
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                // 두 수를 더한 결과럴 HashSet 에 추가
                set.add(numbers[i] + numbers[j]);
            }
        }

        // HashSet 의 값을 오름차순으로 정렬하고 int[] 형태의 배열로 반환하여 반환
        return set.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
