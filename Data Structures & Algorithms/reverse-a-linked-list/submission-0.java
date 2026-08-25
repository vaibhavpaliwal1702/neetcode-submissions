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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            // 1. save curr.next
            ListNode nextTemp = curr.next;
            // 2. flip curr.next = prev
            curr.next = prev;
            // 3. move prev forward
            // 4. move curr forward
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}
