import java.util.ArrayList;
import java.util.List;

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
    ListNode head;
    public boolean isPalindrome(ListNode head) {
        // 提取值+双指针
        // return method1(head);

        // 递归
        if (head == null || head.next == null) return true;
        ListNode slow=head, fast=head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        this.head = head;
        // return method2(slow.next);
        
        
        // 反转后半段链表
        return method3(slow.next);
    }

    private boolean method3(ListNode node) {
        ListNode head=node, tail=node;
        while (tail.next != null) {
            ListNode ans = tail.next;
            tail.next = tail.next.next;
            ans.next = head;
            head = ans;
        }
        while (head != null) {
            if (head.val != this.head.val) return false;
            head = head.next;
            this.head = this.head.next;
        }
        return true;
    }

    private boolean method2(ListNode node) {
        if (node == null) return true;
        if (!method2(node.next) || node.val != this.head.val) return false;
        // if (node == this.head || node.next == this.head) return true;
        this.head = this.head.next;
        return true;
    }
    
    
    private boolean method1(ListNode head) {
        List<Integer> lis = new ArrayList<>();
        while (head != null) {
            lis.add(head.val);
            head = head.next;
        }
        int l=0, r = lis.size()-1;
        while (l < r) {
            if (lis.get(l++) != lis.get(r--)) return false;
        }
        return true;

    }
}