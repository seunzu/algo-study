package LeetCode75.LinkedList;

// Maximum Twin Sum of a Linked List
public class leetcode_2130 {
    class Solution {
        public int pairSum(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode prev = null;
            ListNode cur = slow;

            while (cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }

            int max = 0;
            ListNode first = head;
            ListNode second = prev;

            while (second != null) {
                max = Math.max(max, first.val + second.val);
                first = first.next;
                second = second.next;
            }

            return max;
        }
    }
}
