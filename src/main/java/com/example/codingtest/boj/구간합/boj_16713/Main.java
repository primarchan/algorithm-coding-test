package com.example.codingtest.boj.구간합.boj_16713;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        // 1. 누적 XOR 배열을 구한다.
        int[] acc = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            acc[i] = acc[i - 1] ^ arr[i];
        }

        // 2. Q번의 [s:e] 질문에 대해 누적 XOR 배열을 사용해 구간 XOR 을 구한다.
        int answer = 0;
        while (Q-- > 0) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            answer ^= acc[e] ^ acc[s - 1];
        }

        System.out.println(answer);
    }

}
