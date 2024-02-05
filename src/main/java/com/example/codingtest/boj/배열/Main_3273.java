package com.example.codingtest.boj.배열;

import java.util.Scanner;

public class Main_3273 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        int X = sc.nextInt();

        boolean[] exist = new boolean[1_000_001];

        for (int i = 0; i < N; i++) {
            exist[a[i]] = true;
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int pairValue = X - a[i];

            if (0 <= pairValue && pairValue <= 1_000_000) {
                answer += exist[pairValue] ? 1 : 0;
            }
        }
        System.out.println(answer / 2);
    }

}
