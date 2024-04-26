package com.example.codingtest.programmers.알고리즘_고득점_Kit.해시.의상;

import java.util.*;
public class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        // 각 의상 종류별로 갯수 세기
        for (String[] cloth : clothes) {
            String type = cloth[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0 ) + 1);
        }

        // 조합의 수 계산
        int combinations = 1;  // 모든 의상을 하나도 선택하지 않는 경우를 제외하기 위해 1로 시작
        for (int count : clothesMap.values()) {
            combinations *= (count + 1);// 각 종류별로 선택하지 않는 경우 포함하여 (count + 1)
        }

        // 모든 의상을 하나도 선택하지 않는 경우 제외
        return combinations - 1;
    }

}
