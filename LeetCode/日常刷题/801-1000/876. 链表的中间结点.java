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
    public ListNode middleNode(ListNode head) {
        // l = (r+1 >> 1)
        // 1, 2, 3
        // 1, 2, 3, 4
        ListNode l=head, r=head;
        while (r != null && r.next != null) {
            l = l.next;
            r = r.next.next;
        }
        return l;
    }
}