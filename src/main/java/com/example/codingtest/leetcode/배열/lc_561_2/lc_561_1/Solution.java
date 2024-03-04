package com.example.codingtest.leetcode.배열.lc_561_2.lc_561_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        // 앞에서부터 오름차순으로 인덱스 반복
        for (int i = 0; i < nums.length; i++) {
            // 짝수 번째일 때 값의 합 계산
            if (i % 2 == 0) {
                sum += nums[i];
            }

            return sum;
        }

        return sum;
    }

}
