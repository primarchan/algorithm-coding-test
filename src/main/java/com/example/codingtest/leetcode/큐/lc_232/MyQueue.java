package com.example.codingtest.leetcode.큐.lc_232;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks
 * 스택을 이용해 다음 연산을 지원하는 큐를 구현하라.
 * - push(x) : 엘리먼트 x 를 큐 마지막에 삽입한다.
 * - pop() : 큐 처음에 있는 엘리먼트를 삭제한다.
 * - peek() : 큐 처음에 있는 엘리먼트를 조회한다.
 * - empty() : 큐가 비어 있는지 여부를 리턴한다.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class MyQueue {

    // 삽입할 때 사용하는 스택 선언
    Deque<Integer> input = new ArrayDeque<>();

    // 추출할 때 사용하는 스택 선언
    Deque<Integer> output = new ArrayDeque<>();

    public MyQueue() {

    }

    public void push(int x) {
        // 삽입은 삽입 스택에 단순 추가
        input.push(x);
    }

    public int pop() {
        // 추출 스택 조회하면서 비어 있다면 처리 진행
        peek();
        // 추출 스택에 있는 마지막 값 추출
        return output.pop();
    }

    public int peek() {
        // 추출 스택에 저장된 게 없다면 진행
        if (output.isEmpty()) {
            // 삽입 스택이 비워질 때까지 진행
            while (!input.isEmpty()) {
                // 삽입 스택에서 추출한 결과를 추출 스택에 삽입 (역순으로 저장한다.)
                output.push(input.pop());
            }
        }
        // 가장 나중에 삽입된 결과 조회
        return output.peek();
    }

    public boolean empty() {
        // 두 스택이 모두 비어야 비어 있는 것으로 처리
        return input.isEmpty() && output.isEmpty();
    }

}
