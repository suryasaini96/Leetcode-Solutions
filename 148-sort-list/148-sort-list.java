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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMiddleNode(head); 
        ListNode mid_plus_one = mid.next;
        mid.next = null;
        
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(mid_plus_one);
        ListNode mergedHead = merge(leftHead, rightHead);
        return mergedHead;
    }
    
    private ListNode getMiddleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode leftHead, ListNode rightHead){
        ListNode dummy = new ListNode(0);
        ListNode itr = dummy;

        while (leftHead!=null && rightHead!=null){
            if (leftHead.val<=rightHead.val){
                itr.next = leftHead;
                leftHead = leftHead.next;
            } else {
                itr.next = rightHead;
                rightHead = rightHead.next;
            } 
            itr = itr.next;
        }
        if (leftHead==null)
            itr.next = rightHead;
        else if (rightHead==null)
            itr.next = leftHead;
        return dummy.next;
    }
}