package com.example.codingtest.sample.스택.문제_13;

import java.util.ArrayDeque;

/**
 * 크레인 인형 뽑기 게임
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/13.java
 *
 * 시간복잡도 : O(N^2 + M)
 */
public class Solution {
    public int solution(int[][] board, int[] moves) {
        // 1. 각 열에 대한 스택을 생성합니다.
        ArrayDeque<Integer>[] lanes = new ArrayDeque[board.length];

        for (int i = 0; i <lanes.length ; i++) {
            lanes[i] = new ArrayDeque<>();
        }

        // 2. board 를 역순으로 탐색하며, 각 열의 인형을 lanes 에 추가합니다.
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }

        // 3. 인형을 담을 bucket 을 생성합니다.
        ArrayDeque<Integer> bucket = new ArrayDeque<>();

        // 4. 사라진 인형의 총 개수를 저장할 변수를 초기화합니다.
        int answer = 0;

        // 5. moves 를 순화하며, 각 열에서 인형을 뽑아 bucket 에 추가합니다.
        for (int move : moves) {
            if (!lanes[move - 1].isEmpty()) { // 해당 열에 인형이 있는 경우
                int doll = lanes[move - 1].pop();

                // 6. 바구니에 인형이 있고, 가장 위에 있는 인형과 같은 경우
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else { // 7. 바구니에 인형이 없거나, 가장 위에 있는 인형과 다른 경우
                    bucket.push(doll);
                }
            }
        }

        return answer;
    }

}
