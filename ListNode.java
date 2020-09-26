package com.leetcode;

/**
 * Definition for singly-linked list. 
 * public class ListNode { 
 *  int val; 
 *  ListNode next; 
 *  ListNode(int x) { val = x; } }
 */

public class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x){
        val = x;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}
}