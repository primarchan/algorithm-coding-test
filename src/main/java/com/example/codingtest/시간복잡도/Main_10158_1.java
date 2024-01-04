package com.example.codingtest.시간복잡도;

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

public class Main_10158_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();  // 격자 가로 길이
        int H = sc.nextInt();  // 격자 세로 길이
        int P = sc.nextInt();  // 초기 위치 좌표 값 (P, Q)
        int Q = sc.nextInt();  // 초기 위치 좌표 값 (P, Q)
        int T = sc.nextInt();  // 출발 후 시간

        int timeX = T % (2 * W);
        int currentX = P;
        int deltaX = 1;

        while (timeX -- > 0) {
            if (currentX == W) {
                deltaX = -1;
            } else if (currentX == 0) {
                deltaX = 1;
            }
            currentX += deltaX;
        }

        int timeY = T % (2 * H);
        int currentY = Q;
        int deltaY = 1;

        while (timeY-- > 0) {
            if (currentY == H) {
                deltaY = -1;
            } else if (currentY == 0) {
                deltaY = 1;
            }
            currentY += deltaY;
        }

        System.out.println(currentX + " " + currentY);
    }

}
