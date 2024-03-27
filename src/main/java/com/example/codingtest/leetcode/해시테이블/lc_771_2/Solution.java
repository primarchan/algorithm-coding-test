package com.example.codingtest.leetcode.해시테이블.lc_771_2;

/**
 * https://leetcode.com/problems/jewels-and-stones
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 해시셋 이용한 풀이
 */
public class Solution {

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> freqs = new HashSet<>();

        // 보석(J) 종류 저장
        for (char j : jewels.toCharArray()) {
            freqs.add(j);
        }

        // 돌(S)이 보석(J)인 경우 +1
        for (char s : stones.toCharArray()) {
            if (freqs.contains(s)) {
                count++;
            }
        }

        return count;
    }

}
