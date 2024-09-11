package com.example.codingtest.boj.그래프.bfs.boj_14442;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, K;
    static int[][] map;
    static int[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N + 1][M + 1];
        visited = new int[N + 1][M + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            String line = sc.next();
            for (int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j - 1) - '0';
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1, 0));
        visited[1][1][0] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.r == N && now.c == M) {
                System.out.println(visited[now.r][now.c][now.isBroken]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr <= 0 || nr > N || nc <= 0 || nc > M) continue;

                if (visited[nr][nc][now.isBroken] == 0) {
                    if (map[nr][nc] == 0) {
                        visited[nr][nc][now.isBroken] = visited[now.r][now.c][now.isBroken] + 1;
                        queue.add(new Point(nr, nc, now.isBroken));
                    } else if (map[nr][nc] == 1 && now.isBroken < K && visited[nr][nc][now.isBroken + 1] == 0) {
                        visited[nr][nc][now.isBroken + 1] = visited[now.r][now.c][now.isBroken] + 1;
                        queue.add(new Point(nr, nc, now.isBroken + 1));
                    }
                }
            }
        }

        System.out.println(-1);
    }

}

class Point {
    int r, c;
    int isBroken;

    public Point(int r, int c, int isBroken) {
        this.r = r;
        this.c = c;
        this.isBroken = isBroken;
    }

}
