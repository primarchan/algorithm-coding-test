package com.example.codingtest.boj.그래프.bfs.boj_2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] maze;
    static int[][] visited;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        maze = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = sc.next();
            for (int j = 1; j <= M; j++) {
                maze[i][j] = line.charAt(j - 1) - '0';
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 1));
        visited[1][1] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nc <= 0 || nc > M || nr <= 0 || nr > N) {
                    continue;
                }

                if (visited[nr][nc] == 0 && maze[nr][nc] == 1) {
                    visited[nr][nc] = visited[now.r][now.c] + 1;
                    q.add(new Point(nr, nc));
                }
            }
        }

        System.out.println(visited[N][M]);
    }
}

class Point {
    int r, c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

}