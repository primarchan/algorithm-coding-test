package com.example.codingtest.코딩_테스트_합격자_되기.트리.문제_29;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 길 찾기 게임 (⭐⭐️⭐️⭐️)
 * 2019 KAKAO BLIND RECRUITMENT
 * https://programmers.co.kr/learn/courses/30/lessons/42892
 * https://github.com/retrogemHK/codingtest_java/blob/main/solution/29.java
 *
 * 시간복잡도 : O(N^2)
 */

public class Solution {
    // 1. Node 클래스 정의
    private static class Node {
        int x, y, num; // 노드의 좌표, 번호 저장
        Node left, right; // 노드의 왼쪽, 오른쪽 자식 노드

        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    // 2. 이진 트리 생성 메서드
    private static Node makeBT(int[][] nodeinfo) {
        // 3. 각 노드에 대한 좌표, 번호를 배열에 저장
        Node[] nodes = new Node[nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        // 4. y 기준으로 내림차순 정렬, y 가 같다면 x 를 기준으로 오름차순 정렬
        Arrays.sort(nodes, (o1, o2) -> {
            if (o1.y == o2.y) {
                return Integer.compare(o1.x, o2.x);
            }
            return Integer.compare(o2.y, o1.y);
        });

        Node root = nodes[0]; // 맨 처음 노드는 무조건 루트

        for (int i = 1; i < nodes.length; i++) {
            Node parent = root;

            while (true) {
                // 5. 부모 노드의 x 좌표가 더 크면 왼쪽으로
                if (nodes[i].x < parent.x) {
                    if (parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    } else {
                        parent = parent.left;
                    }
                } else { // 6. 부모 노드의 x 좌표가 더 작거나 같으면 오른쪽으로
                    if (parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    } else {
                        parent = parent.right;
                    }
                }
            }
        }

        return nodes[0];
    }

    // 7. 전위 순회 메서드
    private static void preOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }

        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }

    // 8. 후위 순회 메서듸
    private static void postOrder(Node curr, ArrayList<Integer> answer) {
        if (curr == null) {
            return;
        }

        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }

    public int[][] solution(int[][] nodeinfo) {
        Node root = makeBT(nodeinfo); // 이진 트리 생성
        ArrayList<Integer> preOrderList = new ArrayList<>();
        preOrder(root, preOrderList); // 전위 순회
        ArrayList<Integer> postOrderList = new ArrayList<>();
        postOrder(root, postOrderList); // 후위 순회

        // 9. 결과 반환
        int[][] answer = new int[2][nodeinfo.length];
        answer[0] = preOrderList.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postOrderList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

}
