package com.example.codingtest.leetcode.배열.lc_1_3;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left != right) {
            // 합이 target 보다 작으면, 왼쪽 포인터를 오른쪽으로 이동
            if (nums[left] + nums[right] < target) {
                left += 1;
            } else if (nums[left] + nums[right] > target) {
                // 합이 target 보다 크면 오른쪽 포인터를 왼쪽으로 이동
                right -= 1;
            } else {
                return new int[]{left, right};
            }
        }
        // 항상 정답이 존재하므로 Null 이 리턴되는 경우는 없음
        return null;
    }

}
