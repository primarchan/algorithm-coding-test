package com.example.codingtest.leetcode.큐.lc_622;

/**
 * https://leetcode.com/problems/design-circular-queue
 */

public class MyCircularQueue {
    int[] q;
    int front = 0, rear = -1, len = 0;

    public MyCircularQueue(int k) {
        // k 크기의 원형 큐로 사용할 배열 선언
        this.q = new int[k];
    }

    public boolean enQueue(int value) {
        // 꽉 차 있지 않다면 진행하지 않음
        if (this.isFull()) {
            return false;
        }
        // rear 포인터 한 칸 앞으로 이동, 최대 크기를 초과하면 나머지 위치로 이동
        this.rear = (this.rear + 1) % this.q.length;

        // rear 위치에 값 삽입
        this.q[rear] = value;

        // 현재 큐의 크기 계산
        this.len++;

        return true;
    }

    public boolean deQueue() {
        // 텅 비어 있다면 진행하지 않음
        if (this.isEmpty()) {
            return false;
        }

        // front 포인터 한 칸 앞으로 이동, 최대 크기를 초과하면 나머지 위치로 이동
        this.front = (this.front + 1) % this.q.length;

        // 현재 큐의 크기 계산
        this.len--;

        return true;
    }

    public int Front() {
        return (this.isEmpty()) ? -1 : this.q[this.front];
    }

    public int Rear() {
        // 맨 뒤에 값을 가져온다.
        return (this.isEmpty()) ? -1 : this.q[this.rear];
    }

    public boolean isEmpty() {
        // 현재 큐의 크기가 0 이면 비어 있음
        return this.len == 0 ;
    }

    public boolean isFull() {
        // 현재 큐의 크기가 전체 큐의 크기와 일치하면 꽉 차 있음
        return this.len == this.q.length;
    }

}
