package com.example.codingtest.코딩_테스트_합격자_되기.큐.문제_16;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 기능 개발
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/16.java
 *
 * 시간복잡도 : O(N)
 */

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();
        int n = progresses.length;

        // 1. 각 작업의 배포 가능일 계산
        int[] daysLeft = new int[n];

        for (int i = 0; i < n; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int count = 0; // 2. 배포될 작업의 수 카운트
        int maxDay = daysLeft[0]; // 3. 현재 배포될 작업 중 가장 늦게 배포될 작업의 가능일

        for (int i = 0; i < n; i++) {
            if (daysLeft[i] <= maxDay) { // 4. 배포 가능일이 가장 늦은 배포일보다 빠르면
                count++;
            } else { // 5. 배포 예정일이 기준 배포일보다 느리면
                answer.add(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }

        answer.add(count); // 6. 마지막으로 카운트된 작업들을 함께 배포

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
