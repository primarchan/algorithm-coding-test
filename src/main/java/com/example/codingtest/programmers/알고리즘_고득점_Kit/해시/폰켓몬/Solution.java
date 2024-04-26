package com.example.codingtest.programmers.알고리즘_고득점_Kit.해시.폰켓몬;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int solution(int[] nums) {
        // 폰켓몬 종류별로 갯수를 세기 위한 해시맵
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 선택해야 하는 폰켓몬 수
        int halfN = nums.length / 2;

        // 폰켓몬 종류의 수
        int numTypes = countMap.size();

        // 선택할 수 있는 폰켓몬 종류의 최댓값을 계산
        // 선택할 수 있는 폰켓몬의 수와 폰켓몬의 종류 수 중 더 작은 값이 최댓값이 됨
        return Math.min(halfN, numTypes);
    }

}
