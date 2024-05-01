package com.example.codingtest.boj.재귀.순열과_조합.boj_15656;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static int[] numbers;
    static boolean[] check;
    static int[] output;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        numbers = new int[n];
        check = new boolean[n];
        output = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        perm(0);

        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();

    public static void perm(int depth) {
        // base case
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        // recursive case
        for (int i = 0; i < n; i++) {
            output[depth] = numbers[i];
            perm(depth + 1);
        }
    }

}
