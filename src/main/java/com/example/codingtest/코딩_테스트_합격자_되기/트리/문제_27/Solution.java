package com.example.codingtest.코딩_테스트_합격자_되기.트리.문제_27;

import java.util.HashMap;

/**
 * 다단계 칫솔 판매 (⭐⭐️)
 * 2021 Dev-Matching: 웹 백엔드 개발자(상반기)
 * https://programmers.co.kr/learn/courses/30/lessons/77486
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/27.java
 *
 * 시간복잡도 : O(N * M)
 */

public class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 1. parent 해시맵. key 는 enroll 의 노드, value 는 referral 의 노드로 구성됨
        HashMap<String, String> parent = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
        }

        // 2. total 해시맵 생성
        HashMap<String, Integer> total = new HashMap<>();

        // 3. seller 배열과 amount 배열을 이용하여 이익 분배
        for (int i = 0; i < seller.length; i++) {
            String curName = seller[i];

            // 4. 판매자가 판매한 총금액 계산
            int money = amount[i] * 100;

            // 5. 판매자부터 차례대로 상위 노드로 이동하며 이익 분배
            while (money > 0 && !curName.equals("-")) {
                // 6. 현재 판매자가 받을 금액 계산 (10% 를 제외한 금액)
                total.put(curName, total.getOrDefault(curName, 0) + money - (money / 10));
                curName = parent.get(curName);

                // 7. 10% 를 제외한 금액 계산
                money /= 10;
            }
        }

        // 8. enroll 배열의 모든 노드에 대해 해당하는 이익을 배열로 반환
        int[] answer = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = total.getOrDefault(enroll[i], 0);
        }

        return answer;
    }

}
