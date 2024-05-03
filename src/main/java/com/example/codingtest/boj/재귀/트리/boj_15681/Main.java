package com.example.codingtest.boj.재귀.트리.boj_15681;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer>[] tree;
    static boolean[] visited;
    static int[] sum;

    public static int getSum(int node) {
        if (sum[node] != 0) {
            return sum[node];
        }

        visited[node] = true;
        int result = 1;  // 자기 자신 노드

        for (int child : tree[node]) {
            if (!visited[child]) {
                result += getSum(child);
            }
        }
        sum[node] = result;

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int R = scanner.nextInt();
        int Q = scanner.nextInt();

        visited = new boolean[N + 1];
        sum = new int[N + 1];
        tree = new List[N + 1];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            int U = scanner.nextInt();
            int V = scanner.nextInt();

            tree[U].add(V);
            tree[V].add(U);
        }

        sum[R] = getSum(R);

        for (int i = 0; i < Q; i++) {
            int U = scanner.nextInt();
            System.out.println(sum[U]);
        }
    }

}
