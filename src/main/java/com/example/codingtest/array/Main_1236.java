package com.example.codingtest.array;

import java.util.Scanner;

/**
 * [1236] 성 지키기
 *
 * 문제
 * 모든 행과 열에 경비원이 최소 한 명씩 있어야할 때 추가로 필요한 경비원의 최소 수
 *
 * 1. 각 행/열에 대해 경비원이 있는지 확인한다.
 * 2. 보호받지 못하는 행/열의 갯수를 구한다.
 * 3. 둘 중 큰 값을 출력한다.
 *
 */

public class Main_1236 {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++)
            map[i] = sc.next().toCharArray();

        boolean[] rowExist = new boolean[N];
        boolean[] colExist = new boolean[M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 'X') {
                    rowExist[i] = true;
                    colExist[j] = true;
                }

        int rowNeedCount = N;
        int colNeedCount = M;

        for (int i = 0; i < N; i++)
            if (rowExist[i]) rowNeedCount--;

        for (int i = 0; i < M; i++)
            if (colExist[i]) colNeedCount--;

        System.out.println(Math.max(rowNeedCount, colNeedCount));
    }

}
