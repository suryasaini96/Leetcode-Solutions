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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        int sum = 0;
        recurse(head.next, dummy, 0);
        return dummy.next;
    }
    
    public void recurse(ListNode node, ListNode dummy, int sum) {
        if (node == null) {
           dummy.next = null;
           return; 
        } 
        if (node.val == 0) {
            ListNode newNode = new ListNode(sum);
            dummy.next = newNode;
            recurse(node.next, newNode, 0);
            return;
        }
        sum += node.val;
        recurse(node.next, dummy, sum);
    }
}