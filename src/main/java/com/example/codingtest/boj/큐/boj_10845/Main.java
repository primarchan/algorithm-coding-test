package com.example.codingtest.boj.큐.boj_10845;

import java.io.*;
import java.util.LinkedList;
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
