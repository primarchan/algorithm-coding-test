package com.example.codingtest.leetcode.스택.lc_739;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/daily-temperatures
 * 매일의 온도 리스트 Temperature 를 입력받아서, 더 따뜻한 날씨를 위해서는 며칠을 더 기다려야 하는지를 출력하라.
 */

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 결과를 담을 정수형 배열 선언
        int[] result = new int[temperatures.length];

        // 결과 처리를 위한 스택 선언
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            // 현재 온도가 스택에 있는 온도보다 높다면 꺼내서 결과를 업데이트한다.
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int last = stack.pop();

                // 결과 업데이트
                result[last] = i - last;
            }

            // 현재 인덱스를 스택에 삽입
            stack.push(i);
        }

        return result;
    }

}
