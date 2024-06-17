package com.example.codingtest.programmers.알고리즘_고득점_Kit.스택_큐.프로세스;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int solution(int[] priorities, int location) {
        // 프로세스의 우선순위와 인덱스를 저장할 클래스
        class Process {
            final int priority;
            final int index;

            Process(int priority, int index) {
                this.priority = priority;
                this.index = index;
            }
        }

        // 우선순위 큐를 사용하여 높은 우선순위부터 처리
        PriorityQueue<Process> priorityQueue = new PriorityQueue<>((a, b) -> b.priority - a.priority);
        Queue<Process> queue = new LinkedList<>();

        // 프로세스를 큐에 추가
        for (int i = 0; i < priorities.length; i++) {
            Process process = new Process(priorities[i], i);
            queue.offer(process);
            priorityQueue.offer(process);
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            Process current = queue.poll();
            // 현재 프로세스의 우선순위가 가장 높은 경우 실행
            if (current.priority == priorityQueue.peek().priority) {
                priorityQueue.poll();
                answer++;
                // 목표 프로세스를 실행한 경우 실행 순서를 반환
                if (current.index == location) {
                    return answer;
                }
            } else {
                // 우선순위가 높은 프로세스가 있다면 다시 큐에 추가
                queue.offer(current);
            }
        }

        return answer; // 이 부분은 도달하지 않음
    }

}
