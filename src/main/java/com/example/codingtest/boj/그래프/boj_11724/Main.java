package com.example.codingtest.boj.그래프.boj_11724;

import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            graph[src][dest] = 1;
            graph[dest][src] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                // dfs(i);
                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    /* Queue 를 사용한 BFS */
    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }


    /* Stack 을 이용한 DFS */
    static void dfs(int node) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(node);
        visited[node] = true;

        while (!deque.isEmpty()) {
            int now = deque.pop();

            for (int i = 1; i <= N; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    deque.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    /* 재귀를 이용한 DFS */
    static void dfsRecursion(int node) {
        visited[node] = true;

        for (int i = 1; i <= N; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfsRecursion(i);
            }
        }
    }

}
