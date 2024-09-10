package com.example.codingtest.boj.그래프.bfs.boj_9019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            int in = sc.nextInt();
            int out = sc.nextInt();
            boolean[] check = new boolean[10_000];
            char[] cmd = {'D', 'S', 'L', 'R'};

            Queue<Register> queue = new LinkedList<>();
            queue.add(new Register(in, new StringBuilder()));
            check[in] = true;

            while (!queue.isEmpty()) {
                Register now = queue.poll();

                if (now.num == out) {
                    System.out.println(now.cmd);
                    break;
                }

                int[] next = {now.calcD(), now.calcS(), now.calcL(), now.calcR()};

                for (int i = 0; i < 4; i++) {
                    if(!check[next[i]]){
                        check[next[i]] = true;
                        queue.add(new Register(next[i], new StringBuilder(now.cmd).append(cmd[i])));
                    }
                }
            }
        }
    }
}

class Register {
    int num;
    StringBuilder cmd;

    Register(int num, StringBuilder cmd) {
        this.num = num;
        this.cmd = cmd;
    }

    public int calcD() {
        return (num * 2) % 10000;
    }

    public int calcS() {
        return (num - 1) < 0 ? 9999 : num - 1;
    }

    public int calcL() {
        return (num % 1000) * 10 + num / 1000;
    }

    public int calcR() {
        return (num % 10) * 1000 + num / 10;
    }

}