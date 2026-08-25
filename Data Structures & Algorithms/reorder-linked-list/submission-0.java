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

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null; // cuts first half off from second half

        // Reverse Second
        ListNode prev = null;
        ListNode curr = second;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // prev now contains reversed list

        ListNode first = head;
        ListNode second1 = prev;

        while (second1 != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second1.next;

            first.next = second1;
            second1.next = temp1;

            first = temp1;
            second1 = temp2;
        }
    }
}
