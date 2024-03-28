package com.example.codingtest.leetcode.해시테이블.lc_347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements
 */

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        // 각 엘리먼트의 빈도수를 저장할 해시맵 선언, 엘리먼트 => 빈도수
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // 각 엘리먼트의 빈도수를 반복하며 계산하여 저장
        for (int n : nums) {
            // 처음 빈도수를 계산하는 엘리먼트는 기본값으로 0 으로, 모두 +1 하여 저장
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        // 빈도순으로 정렬되는 우선순위 큐 선언
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // 우선순위 큐에 각 엘리먼트와 빈도수 삽입
        for (int element : frequencyMap.keySet()) {
            pq.add(new int[]{element, frequencyMap.get(element)});
        }

        // 결과로 리턴할 변수 선언
        int[] result = new int[k];

        // k 번까지만 반복하여 우선순위 큐에서 결과 추출
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }

}
