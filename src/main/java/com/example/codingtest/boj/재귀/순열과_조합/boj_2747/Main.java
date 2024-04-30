package com.example.codingtest.boj.재귀.순열과_조합.boj_2747;

import java.util.Scanner;

public class Main {
    /**
     * Base Case
     * - 계산 없이 바로 답을 구할 수 있는 경우
     * - (n==1) 혹은 (n==2)
     *
     * Recursive Case
     * - 재귀 호출이 일어나는 경우
     * - fibo(n) = fibo(n-1) + fibo(n-2)
     */
    static int[] cache = new int[50];

    static int fibo(int n ) {
        if (n == 1 || n == 2) {
            return 1;
        }

        if (cache[n] != 0) {
            return cache[n];
        }

        cache[n] = fibo(n-1) + fibo(n-2);
        return cache[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = fibo(n);
        System.out.println(result);
    }

}
