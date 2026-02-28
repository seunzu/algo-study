package LeetCode75.LinkedList;

// Reverse Linked List
public class leetcode_206 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;

            while (cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            return prev;
        }
    }
}
