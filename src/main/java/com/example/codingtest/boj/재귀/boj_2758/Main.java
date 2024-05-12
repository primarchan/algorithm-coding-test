package com.example.codingtest.boj.재귀.boj_2758;

import java.util.Scanner;

public class Main {
    public static long[][] mem;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            mem = new long[n + 1][m + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    mem[i][j] = -1;
                }
            }

            System.out.println(solve(n, m));
        }
    }

    public static long solve(int i, int last) {
        // Base case
        if (last <= 0) {
            return 0;
        }

        // i == 1
        if (i == 1) {
            return last;
        }

        // Recursive case
        if (mem[i][last] == -1) {
            mem[i][last] = solve(i - 1, last / 2) + solve(i, last - 1);
        }

        return mem[i][last];
    }

}
