package com.example.codingtest.boj.시간복잡도;

import java.util.Scanner;

/**
 * X(P + T) = X((P + T) % 2W)
 * Y(P + T) = Y((P + T) % 2H)
 *
 * currentX <= W -> currentX
 * currentX > W -> W - (currentX - W) = 2W - currentX
 *
 * X(t) = W - |W - t|
 */

public class Main_10158_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();  // 격자 가로 길이
        int H = sc.nextInt();  // 격자 세로 길이
        int P = sc.nextInt();  // 초기 위치 좌표 값 (P, Q)
        int Q = sc.nextInt();  // 초기 위치 좌표 값 (P, Q)
        int T = sc.nextInt();  // 출발 후 시간

        int currentX = (T + P) % (2 * W);
        int currentY = (T + Q) % (2 * H);

        if (currentX > W) {
            currentX = 2 * W - currentX;
        }

        if (currentY > H) {
            currentY = 2 * H - currentY;
        }

        System.out.println(currentX + " " + currentY);
    }

}
