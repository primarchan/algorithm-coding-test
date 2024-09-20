package com.example.codingtest.programmers.그래프.p_49189;

import java.util.*;

/**
 * 섬 연결하기 (⭐⭐⭐)
 * https://programmers.co.kr/learn/courses/30/lessons/49189
 * 시간복잡도 : O(N + V)
 */

public class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        distances[1] = 0;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (distances[next] == -1) {
                    distances[next] = distances[now] + 1;
                    queue.add(next);
                }
            }
        }
        int maxDistance = Arrays.stream(distances).max().getAsInt();

        return (int) Arrays.stream(distances).filter(x -> x == maxDistance).count();
    }

}
