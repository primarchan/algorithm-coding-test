package com.example.codingtest.boj.그래프.boj_2606;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    static int V, E;
    static int[][] graph;
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        graph = new int[V + 1][V + 1];
        visited = new boolean[V + 1];

        for (int i = 0 ; i < E; i++) {
            int src = sc.nextInt();
            int dst = sc.nextInt();
            graph[src][dst] = 1;
            graph[dst][src] = 1;
        }

        // dfs(1);
        bfs(1);
        System.out.println(cnt - 1);
    }

    static void dfs(int node) {
        visited[node] = true;
        cnt++;

        for (int i = 1; i <= V; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int node) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            cnt++;

            for (int i = 1; i <= V; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
