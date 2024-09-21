package com.example.codingtest.programmers.알고리즘_고득점_Kit.BFS_DFS.p_43163;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 단어 변환 (⭐⭐⭐)
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * 시간복잡도 : O(N * M)
 */

public class Solution {
    // 1. 단어 변환 함수 정의
    public int solution(String begin, String target, String[] words) {
        // 2. target 이 words 배열에 없으면 변환 불가능하므로 0 반환
        if (!Arrays.asList(words).contains(target)) return 0;

        // 3. BFS 탐색을 위한 큐와 방문 여부를 확인할 배열 준비
        Queue<Word> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        // 4. 시작 단어를 큐에 추가 (변환 횟수 0부터 시작)
        queue.offer(new Word(begin, 0));

        while (!queue.isEmpty()) {
            Word current = queue.poll();

            // 5. 큐에서 꺼낸 단어가 target 과 동일하면 변환 횟수 반환
            if (current.word.equals(target)) return current.count;

            // 6. 현재 단어와 한 글자 차이나는 단어를 찾아 큐에 추가
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isOneLetterDifferent(current.word, words[i])) {
                    visited[i] = true;  // 방문 처리
                    queue.offer(new Word(words[i], current.count + 1));  // 변환 횟수 +1
                }
            }
        }

        // 7. 변환 불가능하면 0 반환
        return 0;
    }

    // 8. 두 단어가 한 글자만 다른지 확인하는 함수
    private boolean isOneLetterDifferent(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) count++;
        }
        return count == 1;  // 한 글자만 다르면 true
    }
}

// 9. 단어와 변환 횟수를 함께 저장하기 위한 클래스
class Word {
    String word;
    int count;

    Word(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
