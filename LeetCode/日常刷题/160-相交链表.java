/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
            if (node1 == null && node2 != null) node1 = headB;
            if (node2 == null && node1 != null) node2 = headA;
        }
        return node1;
    }
}