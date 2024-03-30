package com.example.codingtest.boj.큐.boj_10845;

import java.io.*;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int lastValue = -1;

        while (N-- > 0) {
            String[] command = br.readLine().split(" ");

            if (command[0].equals("push")) {
                lastValue = Integer.parseInt(command[1]);
                queue.offer(lastValue);
            } else if (command[0].equals("pop")) {
                bw.write(queue.isEmpty() ? "-1\n" : queue.poll() + "\n");
            } else if (command[0].equals("size")) {
                bw.write(queue.size() + "\n");
            } else if (command[0].equals("empty")) {
                bw.write(queue.isEmpty() ? "1\n" : "0\n");
            } else if (command[0].equals("front")) {
                bw.write(queue.isEmpty() ? "-1\n" : queue.peek() + "\n");
            } else if (command[0].equals("back")) {
                bw.write(queue.isEmpty() ? "-1\n" : lastValue + "\n");
            }
        }

        bw.flush();
    }

}

class MyQueue<E> {
    private int size = 0;
    private Node<E> frontNode = null;
    private Node<E> rearNode = null;

    public static class Node<E> {
        E item;
        Node<E> next;
        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }

    }

    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element, null);

        if (size == 0) {
            frontNode = newNode;
        }

        rearNode.next = newNode;
        rearNode = newNode;
        size++;
    }

    public E dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is Empty.");
        }

        E item = frontNode.item;;
        frontNode = frontNode.next;

        if (frontNode == null) {
            rearNode = null;
        }

        size--;

        return item;
    }

    public E getFront() {
        return frontNode.item;
    }

    public E getRear() {
        return rearNode.item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}