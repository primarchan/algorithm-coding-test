package com.example.codingtest.boj.그래프.bfs.boj_7562;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] board;
    static int[][] visited;
    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int t = 0; t < testCase; t++) {
            N = sc.nextInt();
            board = new int[N][N];
            visited = new int[N][N];
            Point start  = new Point(sc.nextInt(), sc.nextInt());
            Point end = new Point(sc.nextInt(), sc.nextInt());
            Queue<Point> queue = new LinkedList<>();
            queue.add(start);
            visited[start.r][start.c] = 1;

            while (!queue.isEmpty()) {
                Point now = queue.poll();

                if (now.r == end.r && now.c == end.c) {
                    System.out.println(visited[end.r][end.c] - 1);
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nr = now.r + dr[i];
                    int nc = now.c + dc[i];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        continue;
                    }

                    if (visited[nr][nc] == 0) {
                        visited[nr][nc] = visited[now.r][now.c] + 1;
                        queue.add(new Point(nr, nc));
                    }
                }
            }
        }

    }

}

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

}