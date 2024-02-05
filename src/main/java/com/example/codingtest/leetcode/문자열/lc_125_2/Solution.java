package com.example.codingtest.leetcode.문자열.lc_125_2;

public class Solution {
    public boolean isPalindrome(String s) {
        // 정규식으로 유효한 문자만 추출한 다음 모두 소문자로 변경
        String s_filtered = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // 문자열을 뒤집은 다음 String 으로 변경
        String s_reversed = new StringBuilder(s_filtered).reverse().toString();

        // 두 문자열이 동일한지 비교
        return s_filtered.equals(s_reversed);
    }

}
