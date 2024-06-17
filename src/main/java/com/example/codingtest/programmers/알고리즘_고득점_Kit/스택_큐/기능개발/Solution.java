package com.example.codingtest.programmers.알고리즘_고득점_Kit.스택_큐.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> deployCounts = new ArrayList<>();
        Queue<Integer> daysQueue = new LinkedList<>();

        // 각 기능이 완료되기까지 남은 일수 계산
        for (int i = 0; i < progresses.length; i++) {
            int remainingProgress = 100 - progresses[i];
            int days = (int) Math.ceil((double) remainingProgress / speeds[i]);
            daysQueue.add(days);
        }

        // 첫 번째 기능이 완료되는 날
        int currentDeployDay = daysQueue.poll();
        int count = 1;

        while (!daysQueue.isEmpty()) {
            int day = daysQueue.poll();
            if (day <= currentDeployDay) {
                // 현재 배포일에 함께 배포할 수 있는 경우
                count++;
            } else {
                // 새로운 배포 시작
                deployCounts.add(count);
                currentDeployDay = day;
                count = 1;
            }
        }

        // 마지막 배포 횟수 추가
        deployCounts.add(count);

        // 결과를 int 배열로 변환하여 반환
        int[] result = new int[deployCounts.size()];

        for (int i = 0; i < deployCounts.size(); i++) {
            result[i] = deployCounts.get(i);
        }

        return result;
    }

}
