package com.example.codingtest.정렬.boj_1181;

/**
 * BOJ #1181 [단어 정렬]
 * https://www.acmicpc.net/problem/1181
 *
 * 문제
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 * 1. 길이가 짧은 것부터
 * 2. 길이가 같으면 사전 순으로
 * 단, 중복된 단어는 하나만 남기고 제거해야 한다.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /**
         * 정렬 후, 같은 값은 연속해서 모여있기 때문에
         * 중복을 제거 후 정렬하기 보다 정렬 후 중복을 건너뛰는 것이 유리하다.
         */

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }

        // 1. 길이가 짧은 순서
        // 2. 길이가 동일하면 사전 순서
        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        // 중복된 단어는 하나만 남기고 제거
        System.out.println(words[0]);  // 첫 번째 원소 출력
        for (int i = 1; i < N; i++) {
            if (!words[i].equals(words[i - 1])) {
                System.out.println(words[i]);
            }
        }

    }

}
