package com.example.codingtest.sample.큐.문제_15;
/**
 * 요세푸스 문제
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/15.java
 *
 * 시간복잡도 : O(N * K)
 */
import java.util.ArrayDeque;

public class Solution {
    private int solution(int N, int K) {
        // 1. 1 부터 N 까지의 번호를 deque 에 추가
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <=N; i++) {
            deque.addLast(i);
        }

        // 2. deque 에 하나의 요소가 남을 때까지 반복
        while (deque.size() > 1) {
            // 3. K 번째 요소를 찾기 위해 앞에서부터 제거하고 뒤에 추가
            for (int i = 0; i < K - 1; i++) {
                deque.addLast(deque.pollFirst());
            }

            deque.pollFirst(); // 4. K 번째 요소 제거
        }

        return deque.pollFirst(); // 5. 마지막으로 남은 요소 반환
    }

}
