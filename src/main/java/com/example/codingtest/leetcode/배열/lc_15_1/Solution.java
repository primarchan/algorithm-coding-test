package com.example.codingtest.leetcode.배열.lc_15_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();
        Arrays.sort(nums);

        // Brute Force n^3 반복
        for (int i = 0; i < nums.length - 2; i++) {
            // 중복된 값 건너뛰기, 이 처리를 하지 않으면 같은 값이 두 번 나올 수 있다.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <nums.length - 1; i++) {
                // 중복된 값 건너뛰기, 사유 동일
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    // 중복된 값 건너뛰기, 사유 동일
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return results;
    }

}
