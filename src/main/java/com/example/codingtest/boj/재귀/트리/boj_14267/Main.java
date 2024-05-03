package com.example.codingtest.boj.재귀.트리.boj_14267;

/**
 * 칭찬을 기록하는 방식
 * - 칭찬이 발생하다 모든 부하들을 찾아다니기?
 *   - 동일 조직에 칭찬이 여러 번 부여되면 동일한 경로를 반복 탐색한다.
 *   - 나에게 발생한 칭찬을 기록해 두고 모든 입력을 다 받은 뒤, 부하직원에게 한번에 뿌려주면 탐색 횟수를 줄일 수 있다.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] like;
    static int[] parents;
    static List<Integer>[] tree;

    public static void next(int node) {
        for (int child : tree[node]) {
            like[child] += like[node];
            next(child);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        parents = new int[n + 1];
        like = new int[n + 1];
        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            parents[i] = scanner.nextInt();

            if (parents[i] == -1) {
                continue;
            }

            tree[parents[i]].add(i);
        }

        for (int i = 0; i < m; i++) {
            int employee = scanner.nextInt();
            int point = scanner.nextInt();

            like[employee] += point;
        }

        next(1);

        for (int i = 1; i <= n; i++) {
            System.out.print(like[i] + " ");
        }
    }

}
