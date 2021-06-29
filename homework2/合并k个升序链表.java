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
    
    // 分治算法 通常用递归实现
    // 首先把k组链表分成两组 每组k/2个链表
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int n = lists.length;
        return merge(lists, 0, n - 1);
    }
    
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[right];
        
        // 向下递归问题
        int mid = (left + right) / 2;
        ListNode leftList = merge(lists, left, mid);
        ListNode rightList = merge(lists, mid + 1, right);
        
        // 再向上合并结果
        return mergeLeftRight(leftList, rightList);
    }
    
    // 下面就是普通的合并两个有序链表的问题
    private ListNode mergeLeftRight(ListNode leftList, ListNode rightList) {
        if (leftList == null) return rightList;
        if (rightList == null) return leftList;
        
        ListNode protect = new ListNode(0);
        ListNode pre = protect;
        
        while (leftList != null && rightList != null) {
            
            if (leftList.val < rightList.val) {
                pre.next = leftList;
                leftList = leftList.next;
                pre = pre.next;
            } else {
                pre.next = rightList;
                rightList = rightList.next;
                pre = pre.next;
            }
        }
        
        if (leftList == null) {
            pre.next = rightList;
        } else {
            pre.next = leftList;
        }
        
        return protect.next;
    }
    
}