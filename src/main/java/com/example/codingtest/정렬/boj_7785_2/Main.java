package com.example.codingtest.정렬.boj_7785_2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * BOJ #7785 회사에 있는 사람
 * https://www.acmicpc.net/problem/7785
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Set<String> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            String status = sc.next();

            if (status.equals("enter")) {
                set.add(name);     // 집합에 추가
            } else {
                set.remove(name);  // 집합에서 제거
            }
        }

        String[] orderedName = set.toArray(set.toArray(new String[set.size()]));

        for (int i = orderedName.length - 1; i >= 0; i--) {
            System.out.println(orderedName[i]);
        }
    }

}
