package com.example.codingtest.boj.큐.boj_1158;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < K; j++) {
                queue.add(queue.poll());
            }
            answer[i] = queue.poll();
        }

        System.out.println(
                "<" + Arrays.stream(answer)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")) + ">"
        );
    }

}
