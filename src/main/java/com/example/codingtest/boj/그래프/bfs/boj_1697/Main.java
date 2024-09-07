package com.example.codingtest.boj.그래프.bfs.boj_1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new int[100_001];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == K) {
                break;
            }

            int[] next = {now - 1, now + 1, now * 2};

            for (int i = 0; i < 3; i++) {
                if (!isRange(next[i])) {
                    continue;
                }

                if (visited[next[i]] == 0) {
                    visited[next[i]] = visited[now] + 1;
                    queue.add(next[i]);
                }
            }
        }

        System.out.println(visited[K] - 1);
    }

    static boolean isRange(int x) {
        return x >= 0 && x <= 100_000;
    }

}
