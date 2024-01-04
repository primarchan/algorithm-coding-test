package com.example.codingtest.문자열;

import java.util.Scanner;

/**
 * [1919] 애너그램 만들기
 *
 * 입력
 * aabbcc
 * xxyybb
 */

public class Main_1919 {

    public static int[] getAlphabetCount(String str) {
        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int countA[] =getAlphabetCount(a);
        int countB[] = getAlphabetCount(b);

        int answer = 0;

        /*
        for (int i = 0; i < 26; i++) {
            if (countA[i] > countB[i]) {
                answer += countA[i] - countB[i];
            } else if (countB[i] > countA[i]) {
                answer += countB[i] - countA[i];
            }
        }
         */

        for (int i = 0; i < 26; i ++) {
            answer += Math.abs(countA[i] - countB[i]);
        }

        System.out.println(answer);
    }

}
