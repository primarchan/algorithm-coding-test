package com.example.codingtest.bruteforce;

import java.util.Scanner;

public class Main_11005 {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();

        String answer = "";
        while (N > 0) {
            int D = N % B;

            if (D < 10) {
                answer += D;
            } else {
                answer += (char)('A' + D - 10);
            }

            N /= B;
        }

        // System.out.println(new StringBuilder(answer).reverse());
        for (int i = answer.length() - 1; i >=0; i--) {
            System.out.print(answer.charAt(i));
        }
        System.out.println();
    }

}
