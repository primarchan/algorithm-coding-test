package com.example.codingtest.코딩_테스트_합격자_되기.해시.문제_24;

import java.util.*;

/**
 * 신고 결과 받기
 * 2021 KAKAO BLIND RECRUITMENT
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/24.java
 *
 * 시간복잡도 : O(N * 2^M)
 */

public class Solution {
    // 만들 수 있는 메뉴 구성과 총 주문 수를 저장할 해시맵
    private static HashMap<Integer, HashMap<String, Integer>> courseMap;

    public String[] solution(String[] orders, int[] course) {
        // 해시맵 초기화
        courseMap = new HashMap<>();

        for (int i : course) {
            courseMap.put(i, new HashMap<>());
        }

        // 1. 코스를 배열로 만들고 오름차순 정렬해서 가능한 모든 메뉴 구성을 구함
        for (String order: orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }

        ArrayList<String> answer = new ArrayList<>();

        // 2. 모든 코스 후보에 대해서
        for (HashMap<String, Integer> count : courseMap.values()) {
            count.values()
                    .stream()
                    .max(Comparator.comparingInt(o -> o)) // 3. 가장 빈도수가 높은 코스를 찾음
                    .ifPresent(cnt -> count.entrySet().stream() // 4. 코스에 대한 메뉴 수가 가능할 때만
                            .filter(entry -> cnt.equals(entry.getValue()) && cnt > 1) // 5. 최소 2명 이상의 손님으로부터 주문된 단품 메뉴 조합에 대해서만
                            .forEach(entry -> answer.add(entry.getKey())) // 6. 코스 메뉴만 answer 리스트에 추가
                    );
        }

        Collections.sort(answer); // 7. 오름차순 정렬

        return answer.toArray(new String[0]);
    }

    // 만들 수 있는 모든 조합을 재귀 함수를 이용해서 구현
    public static void combinations(int idx, char[] order, String result) {
        // 필요한 코스 메뉴의 수와 일치하는 것만 저장
        if (courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            // 해당 코스의 수를 1 증가
            map.put(result, map.getOrDefault(result, 0) + 1);
        }

        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }

}
