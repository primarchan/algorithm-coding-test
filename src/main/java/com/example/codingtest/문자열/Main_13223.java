package com.example.codingtest.문자열;

import java.util.Scanner;

/**
 * HH:MM:SS 포맷의 두 시각의 차이를 HH:MM:SS 포맷으로 출력하기
 */

public class Main_13223 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String current = sc.next();
        String drop = sc.next();

        String[] currentUnit = current.split(":");
        int currentHour = Integer.parseInt(currentUnit[0]);
        int currentMinute = Integer.parseInt(currentUnit[1]);
        int currentSecond = Integer.parseInt(currentUnit[2]);
        int currentSecondAmount = currentHour * 3600 + currentMinute * 60 + currentSecond;

        String[] dropUnit = drop.split(":");
        int dropHour = Integer.parseInt(dropUnit[0]);
        int dropMinute = Integer.parseInt(dropUnit[1]);
        int dropSecond = Integer.parseInt(dropUnit[2]);
        int dropSecondAmount = dropHour * 3600 + dropMinute * 60 + dropSecond;

        int needSecondAmount = dropSecondAmount - currentSecondAmount;

        if (needSecondAmount <= 0) {
            needSecondAmount += 24 * 3600;
        }

        int needHour = needSecondAmount / 3600;
        int needMinute = (needSecondAmount % 3600) / 60;
        int needSecond = needSecondAmount % 60;

        System.out.printf("%02d:%02d:%02d", needHour, needMinute, needSecond);
    }

}
