package com.example.codingtest.코딩_테스트_합격자_되기.배열.문제_06;
/**
 * 실패율
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/06.java
 *
 * 슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다.
 * 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다.
 * 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
 *
 * 이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다.
 * 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다.
 * 오렐리를 위해 실패율을 구하는 코드를 완성하라.
 *
 * 실패율은 다음과 같이 정의한다.
 * 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages 가 매개변수로 주어질 때,
 * 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
 *
 * 제약 조건
 * 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
 * stages 의 길이는 1 이상 200,000 이하이다.
 * stages 에는 1 이상 N + 1 이하의 자연수가 담겨있다.
 * 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
 * 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
 * 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
 * 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
 *
 * 시간복잡도 : O(M + NlogN)
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    public static void main(String[] args) {
//        int N = 5;
//        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
//        int[] result = solution(N, stages);
//
//        System.out.println(Arrays.toString(result));
//    }

    public static int[] solution(int N, int[] stages) {
        // 1. 스테이지별 도전자 수를 구함
        int[] challengers = new int[N + 2];

        for (int stage : stages) {
            challengers[stage] += 1;
        }

        // 2. 스테이지별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        // 3. 각 스테이지를 순회하며, 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (challengers[i] == 0) { // 4. 도전할 사람이 없는 경우, 실패율은 0
                fails.put(i, 0.0);
            } else {
                fails.put(i, challengers[i] / total); // 5. 실패율 구함
                total -= challengers[i]; // 6. 다음 스테이지 실패율을 구하기 위해 현재 스테이지의 인원을 뺌
            }
        }

        // 7. 실패율이 높은 스테이지부터 내림차순으로 정렬
        return fails.entrySet()
                .stream()
                .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

}
