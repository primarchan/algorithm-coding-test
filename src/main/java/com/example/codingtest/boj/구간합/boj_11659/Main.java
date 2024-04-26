package com.example.codingtest.boj.구간합.boj_11659;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 쿼리의 개수

        int[] numbers = new int[N + 1]; // 수를 저장할 배열, 1-indexed
        long[] prefixSum = new long[N + 1]; // 접두사 합 배열, 1-indexed

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            // 접두사 합 계산
            prefixSum[i] = prefixSum[i - 1] + numbers[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            // i번째 수부터 j번째 수까지의 합을 구한다
            long sum = prefixSum[j] - prefixSum[i - 1];
            sb.append(sum).append("\n");
        }

        System.out.print(sb.toString());
    }
}