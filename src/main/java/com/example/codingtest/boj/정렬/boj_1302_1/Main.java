package com.example.codingtest.boj.정렬.boj_1302_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * BOJ #1302 [베스트셀러]
 * https://www.acmicpc.net/problem/1302
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] titles = new String[N];

        for (int i = 0; i < N; i++) {
            titles[i] = sc.next();
        }

        Arrays.sort(titles);

        String maxTitle = titles[0];
        int maxCount = 1;
        int currentCount = 1;

        for (int i = 1; i < N; i++) {
            if (!titles[i].equals(titles[i-1])) {
                currentCount = 0;
            }
            currentCount++;
            if (currentCount > maxCount || (currentCount == maxCount && titles[i].compareTo(maxTitle) < 0)) {
                maxTitle = titles[i];
                maxCount = currentCount;
            }
        }
        System.out.println(maxTitle);
    }

}
