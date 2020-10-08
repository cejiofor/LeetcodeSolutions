package com.leetcode;

public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode p1 = l1;
        ListNode p2 = l2;
        if (l1.val <= l2.val) {
            newHead = p1;
            p1 = p1.next;
        } else{
            newHead = p2;
            p2 = p2.next;
        }

        ListNode curr = newHead.next;


        while (p1.next != null && p2.next != null) {
            if (p1 == null) {
                curr = p2;
                p2 = p2.next;
            } else if (p2 == null) {
                curr = p1;
                p1 = p1.next;
            } else{
                if (p1.val <= p2.val) {
                    curr = p1;
                    p1 = p1.next;
                } else {
                    curr = p2;
                    p2 = p2.next;
                }
            }
            newHead.next = curr;
            curr = curr.next;
        }
        return newHead;
    }

    public static void main(String[] args) {

    }
}
