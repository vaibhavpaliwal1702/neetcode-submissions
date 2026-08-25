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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Step 1: check if at least k nodes remain
        ListNode check = head;
        int count = 0;
        while (check != null && count < k) {
            check = check.next;
            count++;
        }
        if (count < k)
            return head;

        // Step 2: reverse exactly k nodes
        ListNode prev = null;
        ListNode curr = head;
        count = 0;
        while (curr != null && count < k) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
            count++;
        }

        // Step 3: connect the tail of this group (original head) to the recursively-reversed rest
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}
