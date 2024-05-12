package com.example.codingtest.boj.재귀.boj_1182;

import java.util.Scanner;

public class Main {
    static int s;
    static int[] numbers;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        numbers = new int[n];
        s = sc.nextInt();

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        solve(0, 0);
        System.out.println(answer);
    }

    public static void solve(int index, int sum) {
        // Base case
        if (index == numbers.length) {
            return;
        }

        if (sum + numbers[index] == s) {
            answer++;
        }

        // Recursive case
        solve(index + 1, sum + numbers[index]);
        solve(index + 1, sum);
    }

}
