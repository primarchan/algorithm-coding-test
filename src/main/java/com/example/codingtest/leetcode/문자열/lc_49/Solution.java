package com.example.codingtest.leetcode.문자열.lc_49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 애너그램 결과를 보관하기 위한 맵 선언
        Map<String, List<String>> results = new HashMap<>();

        // 입력값인 문자열 배열을 순회
        for (String s : strs) {
            // 문자열을 문자 배열로 변환
            char[] chars = s.toCharArray();

            // 문자 배열 정렬
            Arrays.sort(chars);

            // 문자 배열을 키로 하기 위해 다시 문자열로 변환
            String key = String.valueOf(chars);

            // 만약 기존에 없던 키라면 빈 리스트를 삽입
            if (!results.containsKey(key)) {
                results.put(key, new ArrayList<>());
            }
            // 키에 해당하는 리스트에 추가
            results.get(key).add(s);
        }

        // 문제에서 요구하는 출력값 형태로 변경
        return new ArrayList<>(results.values());
    }

}
