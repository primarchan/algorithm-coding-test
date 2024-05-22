package com.example.codingtest.boj.분할정복.boj_1074;

import java.util.Scanner;

public class Main {
    static int n, r, c;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        solve(n, r, c);
        System.out.println(count);
    }

    static void solve(int n, int r, int c) {
        int boardSize = 1 << n;  // 2^n
        int mid = boardSize / 2;

        if (n == 0) {
            return;
        }

        /* 좌상단 */
        if (r < mid && c < mid) {
            solve(n - 1, r, c);
        }

        /* 우상단 */
        else if (r < mid && c >= mid) {
            count += mid * mid;
            solve(n - 1, r, c - mid);
        }

        /* 좌하단 */
        else if (r >= mid && c < mid) {
            count += mid * mid * 2;
            solve(n - 1, r - mid, c);
        }

        /* 우하단 */
        else if (r >= mid && c >= mid) {
            count += mid * mid * 3;
            solve(n - 1, r - mid, c - mid);
        }
    }

}
