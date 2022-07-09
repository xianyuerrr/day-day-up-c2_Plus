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
        return method2(head);
    }

    /**
     * @description 迭代
     */
    public ListNode method1(ListNode head) {
        if (head == null) return head;
        ListNode newHead = new ListNode(-1, head), tail = head;
        while (tail.next != null) {
            ListNode node = tail.next;
            tail.next = tail.next.next;
            node.next = newHead.next;
            newHead.next = node;
        }
        return newHead.next;
    }

    /**
     * @description 递归
     */
    public ListNode method2(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode nextNode = node.next, newHead = method2(node.next);
        node.next = null;
        nextNode.next = node;
        return newHead;
    }
}