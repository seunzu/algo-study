package LeetCode75.LinkedList;

// Delete the Middle Node of a Linked List
public class leetcode_2095 {
    class Solution {
        public ListNode deleteMiddle(ListNode head) {
            if (head.next == null) return null;

            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;

            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            prev.next = slow.next;

            return head;
        }
    }
}
