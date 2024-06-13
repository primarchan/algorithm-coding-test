package com.example.codingtest.sample.배열.문제_10;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * 괄호 회전하기
 * https://programmers.co.kr/learn/courses/30/lessons/76502
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/10.java
 *
 * 제약 조건
 * s 의 길이는 1 이상 1,000 이하입니다.
 *
 * 시간복잡도 : O(N^2)
 */

public class Solution {
    public int solution(String s) {
        // 1. 괄호 정보를 저장함. 코드를 간결하게 할 수 있음
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int N = s.length(); // 원본 문자열의 길이 저장
        s += s; // 원본 문자열 뒤에 원본 문자열을 이어 붙여서 2번 나오도록 만들어줌
        int answer = 0;

        // 2. 확인할 문자열의 시작 인덱스를 0 부터 N 까지 이동
        A:for (int i = 0; i < N; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            // 3. i (시작 위치)부터 원본 문자열의 길이인 N 개까지 올바른 괄호 문자열인지 확인
            for (int j = i; j < i + N; j++) {
                char c = s.charAt(j);

                // 해시맵 안에 해당 키가 없다면 열리는 괄호임
                if (!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    // 4. 짝이 맞지 않으면 내부 for 문은 종료하고 for 문 A 로 이동
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
            }

            // 5. 3 에서 continue 되지 않았고, 스택이 비어있으면 올바른 괄호 문자열임
            if (stack.isEmpty()) {
                answer++;
            }
        }

        return  answer;
    }

}
