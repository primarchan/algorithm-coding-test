package com.example.codingtest.코딩_테스트_합격자_되기.스택.문제_11;

import java.util.ArrayDeque;

/**
 * 찍지어 제거하기
 * https://programmers.co.kr/learn/courses/30/lessons/12973
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/11.java
 *
 * 시간복잡도 : O(N)
 */

public class Solution {
    public int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 1. 스택이 비어 있지 않고, 현재 문자와 스택의 맨 위 문자가 같으면
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 2. 스택의 맨 위 문자 제거
            } else {
                stack.push(c); // 3. 스택에 현재 문자 추가
            }
        }
        return stack.isEmpty() ? 1 : 0; // 4. 스택이 비어 있으면 1, 그렇지 않으면 0 반환
    }

}
