package com.example.codingtest.코딩_테스트_합격자_되기.백트레킹.문제_43;

import java.util.ArrayList;

/**
 * 1 부터 N 까지 숫자 중 합이 10 이 되는 조합 구하기 (⭐)
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/43.java
 * 시간복잡도 : O(N!)
 */

public class Solution {
    // 1. 조합 결과를 담을 리스트
    private static ArrayList<ArrayList<Integer>> result;
    private static int n;
    private static void backtrack(int sum, ArrayList<Integer> selectNums, int start) {
        // 2. 합이 10 이 되면 결과 리스트에 추가
        if (sum == 10) {
            result.add(selectNums);

            return;
        }

        // 3. 다음에 선택할 수 있는 숫자들을 하나씩 선택하면서
        for (int i = start; i <= n; i++) {
            // 4. 선택한 숫자의 합이 10 보다 작거나 같으면
            if (sum + i <= 10) {
                ArrayList<Integer> list = new ArrayList<>(selectNums);
                list.add(i);

                // 5. 백트래킹 메서드를 재귀적으로 호출합니다.
                backtrack(sum + i, list, i + 1);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> solution(int N) {
        result = new ArrayList<>();
        n = N;

        // 6. 백트래킹 메서드 호출
        backtrack(0, new ArrayList<>(), 1);

        // 7. 모든 부분합의 조합인 result 를 반환
        return result;
    }

}
