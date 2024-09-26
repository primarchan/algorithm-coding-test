package com.example.codingtest.코딩_테스트_합격자_되기.스택.문제_12;

import java.util.ArrayDeque;

/**
 * 주식 가격
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/12.java
 *
 * 시간복잡도 : O(N)
 */

public class Solution {
    public int[] solution(int[] prices) {
        int N = prices.length;
        int[] answer = new int[N]; // 1. 가격이 떨어지지 않는 기간을 저장할 배열

        // 스택을 사용해 이전 가격과 현재 가격을 비교
        ArrayDeque<Integer> stack = new ArrayDeque<>();// 2. 스택 생성
        stack.push(0);

        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 3. 가격이 떨어졌으므로 이전 가격의 기간 계산
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        // 4. 스택에 남아 있는 가격들은 가격이 떨어지지 않는 경우
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = N - 1  - j;
        }

        return answer;
    }

}
