package com.example.codingtest.boj.정렬.boj_10814;

import java.util.Arrays;
import java.util.Scanner;

/**
 * BOJ #10814 [나이순 정렬]
 * https://www.acmicpc.net/problem/10814
 *
 * 문제
 * 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
 * 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
 */

public class Main {

    static class Member implements Comparable<Member> {
        int age;
        String name;
        int idx;

        public Member(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }


        @Override
        public int compareTo(Member o) {
            if (age != o.age) {
                return age - o.age;
            }
            return idx - o.idx;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Member[] members = new Member[N];

        for (int i = 0; i < N; i++) {
            members[i] = new Member(sc.nextInt(), sc.next(), i);
        }

        Arrays.sort(members);

        for (Member member : members) {
            System.out.println(member.age + " " + member.name);
        }
    }

}
