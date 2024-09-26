package com.example.codingtest.코딩_테스트_합격자_되기.큐.문제_17;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 카드 뭉치
 * https://programmers.co.kr/learn/courses/30/lessons/159994
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/17.java
 *
 * 시간복잡도 : O(N + M)
 */

public class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // cards 와 goal 을 deque 로 변환
        ArrayDeque<String> cardsDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cardsDeque2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalQueue = new ArrayDeque<>(Arrays.asList(goal));

        // 1. goalDeque 에 문자열이 남아 있으면 계속 반복
        while (!goalQueue.isEmpty()) {
            // 2. cardsDeque1 의 front 와 일치하는 경우
            if (!cardsDeque1.isEmpty() && cardsDeque1.peekFirst().equals(goalQueue.peekFirst())) {
                cardsDeque1.pollFirst();
                goalQueue.pollFirst();
            }
            // 3. cardsDeque2 의 front 와 일치하는 경우
            else if (!cardsDeque2.isEmpty() && cardsDeque2.peekFirst().equals(goalQueue.peekFirst())) {
                cardsDeque2.pollFirst();
                goalQueue.pollFirst();
            } else {
                break; // 일치하는 요소를 찾지 못했으므로 종료
            }
        }

        // 4. goal 이 비었으면 "Yes" 아니면 "No" 를 반환
        return goalQueue.isEmpty() ? "Yes" : "No";
    }

}
