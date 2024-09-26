package com.example.codingtest.코딩_테스트_합격자_되기.배열.문제_04;

/**
 * 모의고사
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/04.java
 *
 * 제약 조건
 * 시험은 최대 10,000 문제로 구성되어 있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5 중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿이라면 반환하는 값을 오름차순으로 정렬하세요.
 *
 * 시간복잡도 : O(N)
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static int[] solution(int[] answers) {
        // 1. 수포자들의 패턴
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        // 2. 수포자들의 점수를 저장할 배열
        int[] scores = new int[3];

        // 3. 각 수포자의 패턴과 정답이 얼마나 이리하는지 확인
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 4. 가장 높은 점수 저장
        int maxScore = Arrays.stream(scores).max().getAsInt();

        // 5. 가장 높은 점수를 가진 수포자들의 번호를 찾아서 리스트에 담음
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
