package com.example.codingtest.programmers.알고리즘_고득점_Kit.해시.전화번호_목록;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        // 전화번호 목록을 해시맵에 저장
        for (String phone : phone_book) {
            map.put(phone, 1);
        }

        // 각 번호에 대해 모든 접두사가 해시맵에 있는지 검사
        for (String phone : phone_book) {
            for (int i = 0; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);

                if (map.containsKey(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }

}
