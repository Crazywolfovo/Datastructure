package com.datastructure.LinkedList;

// Leetcode 203. Remove Linked List Elements
// https://leetcode.com/problems/remove-linked-list-elements/description/

class Solution2 {

    ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val)
            head = head.next;

        if (head == null)
            return null;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return head;
    }
}