package com.example.codingtest.array;

import java.io.*;

public class Main_10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10_001];

        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= 10_000; i++) {
            while (count[i]-- > 0) {
                bw.write(i + "\n");
            }

            bw.flush();
        }
    }

}
