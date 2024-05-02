package com.example.codingtest.boj.재귀.순열과_조합.boj_15657;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] numbers;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[n];
        output = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        perm(0, 0);

        System.out.println(sb);
    }

    public static void perm(int depth, int start) {
        // base case
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        // recursive case
        for (int i = start; i < n; i++) {
            output[depth] = numbers[i];
            perm(depth + 1, i);
        }
    }

}
