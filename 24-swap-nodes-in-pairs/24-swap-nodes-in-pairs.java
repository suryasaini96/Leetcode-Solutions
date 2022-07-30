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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        return helper(dummyNode, null);
    }
    
    private ListNode helper(ListNode node, ListNode prev) {
        ListNode swappedHead = null;
        
        if (node.next != null && node.next.next != null) {
            swappedHead = helper(node.next.next, node.next);
        } else if (node.next != null) {
            swappedHead = node.next;
        }

        node.next = prev;
        if (prev != null)
            prev.next = swappedHead;
        else
            return swappedHead;

        return node;
    }
}