package com.example.codingtest.leetcode.배열.lc_1_1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        // 입력값 배열을 처음부터 순회
        for (int i = 0; i < nums.length; i++) {
            // 입력값 배열을 그다음부터 순회
            for (int j = i + 1; j < nums.length; i++) {
                // 두 값의 합을 비교해 target 과 일치하는 경우 정답으로 리턴
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        // 항상 정답이 존재하므로 Null 이 리턴되는 경우는 없음
        return null;
    }

}
