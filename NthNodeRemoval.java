package com.leetcode;

import java.util.LinkedList;

public class NthNodeRemoval {
    /*
        Given a linked list, remove the n-th node from the end of list and return its head.
        Example:
        Given linked list: 1->2->3->4->5, and n = 2
        After removing the second node from the end, the linked list becomes 1->2->3->5.
     */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (head != null) {
            linkedList.push(head.val);
            head = head.next;
        }

        ListNode prevNode = null;
        ListNode currNode = null;
        System.out.println(linkedList.size());
        while (!linkedList.isEmpty()) {
            if (count == n) {
                linkedList.pop();
            }else{
                currNode = new ListNode((int) linkedList.pop(), prevNode);
                prevNode = currNode;
            }
            count++;
        }

        return currNode;
    }

    public ListNode removeNthFromEndOne(ListNode head, int n) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode fastNode = newHead;
        ListNode slowNode = newHead;

        //Move curr head to start at n
        int i = 0;
        while (i<n){
            fastNode = fastNode.next;
            i++;
        }

        while (fastNode.next != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;

        return newHead.next;
    }


}
