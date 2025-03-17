package com.example.codingtest.코딩_테스트_합격자_되기.백트레킹.문제_44;

/**
 * 피로도 (⭐)
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/44.java
 * https://school.programmers.co.kr/learn/courses/30/lessons/87946
 * 시간복잡도 : O(N!)
 */
public class Solution {
    private static int answer;
    private static int[][] Dungeons;
    private static boolean[] visited;

    // 백트레킹을 위한 DFS
    private static void backtrack(int k, int cnt) {
        for (int i = 0; i < Dungeons.length; i++) {
            // 1. 현재 피로도(k)가 i번째 던전의 초소 필요 피로도보다 크거나 같고,
            // i번째 던전을 방문한 적이 없다면
            if (!visited[i] && k >= Dungeons[i][0]) {
                visited[i] = true; // i번째 던전을 방문 처리
                // 2. 현재까지의 최대 탐험 가능 던전 수와
                // i번째 던전에서 이동할 수 있는 최대 탐험 가능 던전 수 중 큰 값을 선택하여 업데이트
                backtrack(k - Dungeons[i][1], cnt + 1);
                answer = Math.max(answer, cnt + 1);
                visited[i] = false; // i번째 던전을 다시 방문 취소
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        Dungeons = dungeons;
        // 3. 던전 방문 여부를 저장할 배열
        visited = new boolean[dungeons.length];

        backtrack(k, 0); // 4. DFS 메서드 수행
        return answer;
    }
}
