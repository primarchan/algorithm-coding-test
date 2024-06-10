package com.example.codingtest.sample.스택.문제_09;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 10진수를 2진수로 변환하기
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/09.java
 *
 * 10진수를 입력받아 2진수로 반환하는 solution() 함수를 구현하세요.
 *
 * 제약 조건
 * decimal 1 이상 10억 미만의 자연수
 *
 * 시간복잡도 : O(logN)
 */

public class Solution {
    /**
     * 10진수 -> 2진수 변환 과정
     * 1. 10진수 N을 2로 나눈 나머지. 즉, %2 연산을 한 값을 저장하고, N은 2로 나눔
     * 몫이 0이 아니라면 나머지를 버리고 다시 1을 수행
     * 모든 과정이 끝나고 1에서 자장한 수를 뒤부터 순서대로 가져와 붙이기
     */

    public static String solution(int decimal) {
        Deque<Integer> stack = new ArrayDeque<>();

        while (decimal > 0) {
            int reminder = decimal % 2;
            stack.push(reminder);

            decimal /= 2;
        }

        // String 의 + 연산은 시간복잡도 측면에서 성능이 좋지 않음
        // 따라서 StringBuilder 를 사용했음
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(21));
    }

}
