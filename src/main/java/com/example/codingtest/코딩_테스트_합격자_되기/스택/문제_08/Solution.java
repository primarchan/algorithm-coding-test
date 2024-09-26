package com.example.codingtest.코딩_테스트_합격자_되기.스택.문제_08;

/**
 * 올바른 괄호
 * https://programmers.co.kr/learn/courses/30/lessons/12909
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/08.java
 *
 * 제약 조건
 * 문자열 s 의 길이 : 1000,000 이하의 자연수
 * 문자열 s 는 '(' 또는 ')' 로만 이루어져 있습니다.
 *
 * 시간복잡도 : O(N)
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        char[] a = s.toCharArray();

        for (char c : a) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() == c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
