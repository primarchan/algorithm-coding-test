package com.example.codingtest.코딩_테스트_합격자_되기.그래프.문제_35;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 너비 우선 탐색 순회 (⭐)
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/35.java
 * 시간복잡도 : O(N + E)
 */

public class Solution {
    // 인접 리스트를 저장할 ArrayList 배열
    private static ArrayList<Integer>[] adjList;

    // 방문 여부를 저장할 boolean 배열
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    private static int[] solution(int[][] graph, int start, int n) {
        adjList = new ArrayList[n + 1];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        // 방문 여부를 저장할 배열
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        bfs(start); // 시작 노드에서 너비 우선 탐색 시작

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // BFS 탐색 메서드
    private static void bfs(int start) {
        // 탐색시 맨 처음 방문할 노드를 add 하고 방문 처리
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        // 3. 큐가 비어 있지 않은 동안 반복
        while (!queue.isEmpty()) {
            // 4. 큐에 있는 원소 중 가장 먼저 추가된 원소를 poll 하고 정답 리스트에 추가
            int now = queue.poll();
            answer.add(now);

            // 5. 인접한 이웃 노드들에 대해서
            for (int next : adjList[now]) {
                if (!visited[next]) { // 6. 방문하지 않은 인접한 노드인 경우
                    // 7. 인접한 노드를 방문 처리함
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = { {1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9} };
        int start = 1;
        int n = 9;

        int[] answer = solution(graph, start, n);
        System.out.println(Arrays.toString(answer));
    }

}
