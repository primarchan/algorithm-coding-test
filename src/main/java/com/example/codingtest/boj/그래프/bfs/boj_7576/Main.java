package com.example.codingtest.boj.그래프.bfs.boj_7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        board = new int[N][M];
        visited = new int[N][M];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    queue.add(new Point(i, j));
                    visited[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }

                if (visited[nr][nc] == 0 && board[nr][nc] == 0) {
                    visited[nr][nc] = visited[now.r][now.c] + 1;
                    queue.add(new Point(nr, nc));
                }
            }
        }

        int max = 0;
        boolean yummy = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, visited[i][j]);

                if (visited[i][j] == 0 && board[i][j] == 0) {
                    yummy = false;
                    break;
                }
            }
        }

        if (yummy) {
            System.out.println(max - 1);
        } else
            System.out.println(-1);
    }

}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

}
