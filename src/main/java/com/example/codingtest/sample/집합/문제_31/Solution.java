package com.example.codingtest.sample.집합.문제_31;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * 폰켓몬 (⭐)
 * https://programmers.co.kr/learn/courses/30/lessons/1845
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/31.java
 *
 * 시간복잡도 : O(N)
 */

public class Solution {
    public int solution(int[] nums) {
        // 1. nums 리스트에서 중복을 제거한 집합(set)을 구함
        HashSet<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        // 2. 폰켓몬의 총 수
        int n = nums.length;

        // 3. 선택할 폰켓몬의 수
        int k = n / 2;

        // 4. 중복을 제거한 폰켓몬의 종류 수와 선택할 폰켓몬의 수 중 작은 값 반환
        return Math.min(k, set.size());
    }

    public int solution2(int[] nums) {
        return Math.min((int) Arrays.stream(nums).distinct().count(), nums.length / 2);
    }

}
