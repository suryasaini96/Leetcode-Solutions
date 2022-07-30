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
    public ListNode partition(ListNode head, int x) {
        ListNode lessDummyNode = new ListNode(0);
        ListNode moreDummyNode = new ListNode(0);
        
        ListNode lessNode = lessDummyNode;
        ListNode moreNode = moreDummyNode;
        
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                lessNode.next = curr;
                lessNode = lessNode.next;
            } else {
                moreNode.next = curr;
                moreNode = moreNode.next;
            }
            curr = curr.next;
        }
        
        moreNode.next = null; 
        lessNode.next = moreDummyNode.next;
        return lessDummyNode.next;
    }
}