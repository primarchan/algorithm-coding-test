package com.example.codingtest.leetcode.큐.lc_622;

/**
 * https://leetcode.com/problems/design-circular-queue
 */

public class MyCircularQueue {
    private int capacity; // Queue 의 최대용량
    private int size; // 실제 Queue 에 담긴 element 들의 갯수
    private int head; // 현재 head 의 위치
    private int tail; // 현재 tail 의 위치
    private int[] elements; // elements 배열 (이 문제에서 int queue 를 정의해서 int array 선언)

    public MyCircularQueue(int k) { // 생성자
        this.capacity = k;
        this.size = 0;
        this.head = 0;
        this.tail = 0;
        this.elements = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) { // 만약 Queue 가 꽉찬 상태라면 더 이상 넣을 수 없음
            return false;
        }
        elements[tail] = value; // 현재 tail 의 위치에 value 를 삽입
        tail = (tail + 1) % capacity; // tail 의 인덱스를 한칸 뒤로 밈
        size++; // Queue 에 1개 추가되었다는 의미
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) { // 만약 Queue 가 빈 상태라면 꺼낼 수 없음
            return false;
        }

        // elements[head] = null; // primitive 가 아닐때 loitering 방지
        head = (head + 1) % capacity; // head 의 인덱스를 한칸 뒤로 밈
        size--; // Queue 에서 1개 제거되었다는 의미

        return true;
    }

    public int Front() {
        if (isEmpty()) { // Queue 가 빈 경우에 가져올 것이 없음
            return -1; // 문제에서 -1로 명시되어 있음
        }
        return elements[head % capacity];
    }

    public int Rear() {
        if (isEmpty()) { // Queue 가 빈 경우에 가져올 것이 없음
            return -1;
        }
        // tail 이 0인 경우 elements[-1]을 탐색하게 되어 오류가 발생하는 것을 방지하기 위함
        return elements[(tail + capacity - 1) % capacity];
    }

    public boolean isEmpty() {
        return size == 0; // element 들의 실제 갯수를 의미하는 size 가 0이면 Queue 가 비었다고 할 수 있음
    }

    public boolean isFull() {
        return size == capacity; // size 와 선언시의 용량이 동일하다면 꽉 찼다고 할 수 있음
    }

}
