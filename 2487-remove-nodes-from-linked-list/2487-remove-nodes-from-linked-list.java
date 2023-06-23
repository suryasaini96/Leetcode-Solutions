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
    public ListNode removeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        recurse(head, dummy, -1);
        return dummy.next;
    }
    
    public int recurse(ListNode node, ListNode prev, int maxToRight) {
        if (node == null) {
            return maxToRight;
        }
        maxToRight = recurse(node.next, node, maxToRight);
        if (node.val < maxToRight) { // If node val is less than maxToRight
            // Skip the node
            prev.next = node.next;
            maxToRight = Math.max(maxToRight, node.val);
            return maxToRight;
        }
        return Math.max(maxToRight, node.val);
    }
}