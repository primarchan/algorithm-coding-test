package com.example.codingtest.array;

import java.util.Scanner;

public class Main_10431_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();

        while (P-- > 0) {
            int T = sc.nextInt();
            int[] h = new int[20];

            for (int i = 0; i < 20; i++) {
                h[i] = sc.nextInt();
            }

            int count = 0;
            int[] sorted = new int[20];

            for (int i = 0; i < 20; i++) {
                // 1. 줄 서 있는 학생 중에 자신보다 큰 학생을 찾는다.
                // 1-1. 찾지 못했다면, 줄의 가장 뒤에 선다.
                boolean isFind = false;

                for (int j = 0; j < i; j++) {
                    if (sorted[j] > h[i]) {
                        // 2. 찾았다면, 그 학생의 앞에 선다.
                        isFind = true;

                        // 3. 그 학생과 그 뒤의 학생(들)은 모두 한 칸씩 물러난다.
                        for (int k = i - 1; k >= j; k--) {
                            sorted[k + 1] = sorted[k];
                            count++;
                        }
                        sorted[j] = h[i];
                        break;
                    }
                }
                if (!isFind) {
                    sorted[i] = h[i];
                }
            }
            System.out.println(T + " " + count);
        }

    }

}
