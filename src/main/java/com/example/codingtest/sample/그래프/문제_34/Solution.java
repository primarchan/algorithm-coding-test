package com.example.codingtest.sample.그래프.문제_34;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 깊이 우선 탐색 순회 (⭐)
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/34.java
 * 시간복잡도 : O(N + E)
 */

public class Solution {
    // 인접 리스트 저장할 ArrayList 배열
    private static ArrayList<Integer>[] adjList;

    // 방문 여부를 저장할 boolean 배열
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    private static int[] solution(int[][] graph, int start, int n) {
        // 1. 인접 리스트 초기화
        adjList = new ArrayList[n + 1];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 2. 그래프를 인접 리스트로 변환
        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        // DFS 를 순환한 결과를 반환
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        dfs(start);

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // DFS 탐색 메서드
    private static void dfs(int now) {
        visited[now] = true; // 4. 현재 노드를 방문했음을 저장
        answer.add(now); // 5. 현재 노드를 결과 리스트에 추가

        // 6. 현재 노드와 인접한 노드 순회
        for (int next : adjList[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = { {1, 2}, {2, 3}, {3, 4}, {4, 5} };
        int start = 1;
        int n = 5;

        int[] answer = solution(graph, start, n);
        System.out.println(Arrays.toString(answer));
    }

}
