package com.example.codingtest.boj.배열;

import java.io.*;

public class Main_15552 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- >0) {
            String[] numbers = br.readLine().split(" ");
            int a = Integer.parseInt(numbers[0]);
            int b = Integer.parseInt(numbers[1]);

            bw.write(a + b + "\n");
        }

        bw.flush();
    }

}
