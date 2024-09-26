package com.example.codingtest.코딩_테스트_합격자_되기.해시.문제_20;

import java.util.HashMap;

/**
 * 할인 행사
 * https://programmers.co.kr/learn/courses/30/lessons/131127
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/20.java
 *
 * 시간복잡도 : O(N)
 */

public class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 1. want, number 배열의 값을 해시맵에 저장
        HashMap<String, Integer> wantMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        int answer = 0; // 2. 총 일수를 계산할 변수 초기화

        // 3. 특정일 i 에 회원가입 시 할인받을 수 있는 품목 체크
        for (int i = 0; i < discount.length - 9; i++) {
            // 4. i 일 회원가입 시 할인받는 제품 및 개수를 담을 해시맵
            HashMap<String, Integer> discount10d = new HashMap<>();

            // 5. i 일 회원가입 시 할인받는 제품 및 개수로 해시맵 구성
            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[j])) {
                    discount10d.put(discount[j], discount10d.getOrDefault(discount[j], 0) + 1);
                }
            }

            // 6. 할인하는 상품의 개수가 원하는 수량과 일치하면 정답 변수에 1 추가
            if (discount10d.equals(wantMap)) {
                answer++;
            }
        }

        return answer;
    }

}
