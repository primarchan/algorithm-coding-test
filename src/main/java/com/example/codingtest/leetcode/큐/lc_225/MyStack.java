package com.example.codingtest.leetcode.큐.lc_225;

/**
 * https://leetcode.com/problems/implement-stack-using-queues
 * 큐를 이용해 다음 연산을 지원하는 스택을 구현하라.
 * - push(x) : 엘리먼트 x 를 스택에 삽입한다.
 * - pop() : 스택의 첫 번째 엘리먼트를 삭제한다.
 * - top() : 스택의 첫 번째 엘리먼트를 가져온다.
 * - empty() : 스택이 비어 있는지 여부를 리턴한다.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

class MyStack {

    // 큐 변수, 구현체는 LinkedList 로 선언
    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        // 엘리먼트 삽입
        queue.add(x);

        // 맨 앞에 두는 상태로 전체 재정렬
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        // 재정렬한 상태이므로 큐 연산으로 추출
        return queue.remove();
    }

    public int top() {
        // 재정렬한 상태이므로 큐 연산으로 조회
        return queue.peek();
    }

    public boolean empty() {
        // 크기를 비교해 비어 있는지 확인
        return queue.size() == 0;
    }

}