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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head1 = l1;
        ListNode head2 = l2;
        // 管他什么题 先来一个保护节点
        ListNode protect = new ListNode(0);
        ListNode index = protect;  // 表示当前指示的节点
        
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                index.next = head1;
                index = head1;
                head1 = head1.next;
            } else {
                index.next = head2;
                index = head2;
                head2 = head2.next;
            }
        }
        
        // 完成剩下的链表连接步骤
        if (head1 == null) {
            index.next = head2;
        } else {
            index.next = head1;
        }
        
        return protect.next;
        
    }
}