package com.example.codingtest.코딩_테스트_합격자_되기.해시.문제_22;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 베스트 앨범
 * https://programmers.co.kr/learn/courses/30/lessons/42579
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/22.java
 *
 * 시간복잡도 : O(NlogN)
 */

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();
        HashMap<String, Integer> playMap = new HashMap<>();

        // 1. 장르별 총 재생 횟수와 각 곡의 재생 횟수 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }

            genreMap.get(genre).add(new int[]{i, play});
            playMap.put(genre, playMap.get(genre) + play);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        // 2. 총 재생 횟수가 많은 장르순으로 내림차순 정렬
        playMap.entrySet()
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
                .forEach(entry -> {
                    genreMap.get(entry.getKey()).stream()
                            .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                            .limit(2)
                            .forEach(song -> answer.add(song[0]));
                });

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

}
