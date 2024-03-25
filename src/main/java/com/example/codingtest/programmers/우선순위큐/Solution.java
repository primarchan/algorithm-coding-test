package com.example.codingtest.programmers.우선순위큐;

import java.util.PriorityQueue;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovilles = new PriorityQueue<>();

        for(int s : scoville) {
            scovilles.add(s);
        }

        while(scovilles.peek() < K) {
            if(scovilles.size() > 1) {
                int firstMin = scovilles.remove();
                int secondMin = scovilles.remove();
                scovilles.add(firstMin + (secondMin * 2));
                answer++;
            } else {
                return -1;
            }
        }
        return answer;
    }
}
