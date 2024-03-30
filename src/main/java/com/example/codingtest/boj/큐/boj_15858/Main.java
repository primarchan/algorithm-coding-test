package com.example.codingtest.boj.큐.boj_15858;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue = new LinkedBlockingQueue<>(N);

        while (true) {
            int command = sc.nextInt();

            if (command > 0) {
                if (queue.size() < N) {
                    queue.offer(command);
                }
            } else if (command == 0) {
                queue.poll();
            } else {
                break;
            }
        }

        if (queue.isEmpty()) {
            System.out.println("empty");
        } else {
            while (!queue.isEmpty()) {
                System.out.printf(queue.poll() + " ");
            }
            System.out.println();
        }
    }

}
