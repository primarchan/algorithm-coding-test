package com.example.codingtest.코딩_테스트_합격자_되기.트리.문제_26;

/**
 * 예상 대진표 (⭐️)
 * https://programmers.co.kr/learn/courses/30/lessons/12985
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/26.java
 *
 * 시간복잡도 : O(logN)
 */

public class Solution {
    public int solution(int N, int A, int B) {
        int answer;

        for (answer = 0; A != B; answer++) {
            A = (A + 1) / 2;
            B = (B + 1) / 2;
        }

        return answer;
    }

}
