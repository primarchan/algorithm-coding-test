package com.example.codingtest.문자열;

import java.util.Scanner;

/**
 * [2744] 대소문자 바꾸기
 * 문제
 * 영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.
 */

class Main_2744 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) - 'A' >= 32) {
                sb.append((char) (word.charAt(i) - 32));
            } else {
                sb.append((char) (word.charAt(i) + 32));
            }
        }

        System.out.println(sb);
    }

}
