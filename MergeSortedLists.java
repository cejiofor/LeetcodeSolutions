package com.leetcode;

public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode curr = new ListNode();
        ListNode p1 = l1;
        ListNode p2 = l2;

        if (l1 == null && l2 == null){
            return l1;
        } else if (l2 == null){
            return l1;
        } else if (l1 == null){
            return l2;
        } else if (l1.val <= l2.val) {
            curr = new ListNode(p1.val);
            p1 = p1.next;
        } else{
            curr = new ListNode(p2.val);
            p2 = p2.next;
        }

        newHead = curr;
        // System.out.println(p2.val);
        while (p1 != null && p2 != null) {
            // System.out.println(curr.val);
            // System.out.println("p1 " +p1.val);
            // System.out.println("p2 " +p2.val);
            // if (p1 == null) {
            //     curr.next = new ListNode(p2.val);
            //     p2 = p2.next;
            // }
            if (p1.next == null) {
                curr.next = p1;
            }
            if (p2.next == null) {
                curr.next = p2;
            } else{
                if (p1.val <= p2.val) {
                    curr.next = new ListNode(p1.val);
                    p1 = p1.next;

                    System.out.println("end "+curr.next.val);
                } else{
                    curr.next = new ListNode(p2.val);
                    p2 = p2.next;
                }
            }
            curr = curr.next;
        }

        return newHead;
    }

    public static void main(String[] args) {

    }
}
