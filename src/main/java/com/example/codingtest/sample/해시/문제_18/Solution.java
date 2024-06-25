package com.example.codingtest.sample.해시.문제_18;

import java.util.HashSet;

/**
 * 두 개의 수로 특정값 만들기
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/18.java
 *
 * 시간복잡도 : O(N + K)
 */

public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 8};
        int target = 6;
        System.out.println(solution(arr, target));
    }

    private static boolean solution(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (set.contains(target - i)) {
                return true;
            }

            set.add(i);
        }

        return false;
    }

}
