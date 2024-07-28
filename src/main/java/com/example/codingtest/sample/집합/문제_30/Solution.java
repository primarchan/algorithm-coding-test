package com.example.codingtest.sample.집합.문제_30;

import java.util.ArrayList;

/**
 * 길 찾기 게임 (⭐⭐️)
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/30.java
 *
 * 시간복잡도 : O(NlogN)
 */

public class Solution {
    // 부모 저장을 위한 배열
    private static int[] parent;

    // 루트 노드를 찾는 메서드
    private static int find(int x) {
        // 만약 x 의 부모가 자기 자신이면, 즉 x 가 루트 노드라면 x를 반환
        if (parent[x] == x) {
            return x;
        }

        // 그렇지 않다면 x 의 부모를 찾아서 parent[x] 에 저장합니다.
        parent[x] = find(parent[x]);

        return parent[x]; // 찾은 루트 노드를 반환
    }

    private static void union(int x, int y) {
        int root1 = find(x); // x 가 속한 집합의 루트 노드 찾기
        int root2 = find(y); // y 가 속한 집합의 루트 노드 찾기
        parent[root2] = root1; // y 가 속한 집합을 x 가 속한 집합에 합침
    }

    private static Boolean[] solution(int k, int[][] operation) {
        // 노드의 수 만큼 배열 생성
        parent = new int[k];

        // 처음에는 각 노드가 자기 자신을 부모로 가지도록 초기화
        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        ArrayList<Boolean> answer = new ArrayList<>();

        for (int[] op : operation) {
            if (op[0] == 0) { // 0 연산이면
                union(op[1], op[2]);
            } else {
                answer.add(find(op[1]) == find(op[2]));
            }
        }

        return answer.toArray(new Boolean[0]);
    }

}
