package com.example.codingtest.코딩_테스트_합격자_되기.배열.문제_07;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 실패율
 * https://programmers.co.kr/learn/courses/30/lessons/49994
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/07.java
 *
 * 제약 조건
 * dirs 는 string 형으로 주어지며, 'U', 'D', 'R', 'L' 이외에 문자는 주어지지 않습니다.
 * dirs 의 길이는 500 이하의 자연수입니다.
 *
 * 시간복잡도 : O(N)
 */

public class Solution {
    // 1. 좌표평면을 벗어나는지 체크하는 메서드
    private static boolean isValidMove(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }

    // 2. 다음 좌표 결정을 위한 해시맵 생성
    private static final HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }

    public int solution(String dirs) {
        initLocation();
        int x = 5, y = 5;

        // 3. 겹치는 좌표는 1개로 처리하기 위함
        HashSet<String> answer = new HashSet<>();

        // 4. 주어진 명령어로 움직이면서 좌표 저장
        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];

            if (!isValidMove(nx, ny)) { // 5. 벗어난 좌표는 인정하지 않음
                continue;
            }

            // 6. A 에서 B 로 간 경우 B 에서 A 도 추가해야 함(총 경로의 개수는 방향성이 없음)
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);

            // 7. 좌표를 이동했으므로 업데이트
            x = nx;
            y = ny;
        }

        return answer.size() / 2;
    }

}
