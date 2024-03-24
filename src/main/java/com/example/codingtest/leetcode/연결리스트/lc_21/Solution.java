package com.example.codingtest.leetcode.연결리스트.lc_21;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}

public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 두 노드 중 한쪽이 널이면 널이 아닌 노드를 리턴
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        // list2 가 더 크면 list1 에 재귀 호출 결과를 엮고 list1 을 리턴
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);

            return list1;
        } else {
            // list1 이 더 크거나 같으면 list2 에 재귀 호출 결과를 엮고 list2 를 리턴
            list2.next = mergeTwoLists(list1, list2.next);

            return list2;
        }
    }

}
