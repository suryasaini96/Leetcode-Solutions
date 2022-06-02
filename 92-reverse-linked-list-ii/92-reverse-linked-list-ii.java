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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode node = dummyHead;
        for(int i = 0; i < left-1; i++) {
            node = node.next;
        }
        
        ListNode endOfFirstPart = node;
        ListNode endOfReversedNode = node.next;
        
        ListNode previousNode = null;
        node = node.next;
        ListNode nextNode = null;
        for(int i = left-1; i < right; i++) {
            nextNode = node.next;
            
            node.next = previousNode;
        
            previousNode = node;
            node = nextNode;
        }
        
        endOfFirstPart.next = previousNode;
        endOfReversedNode.next = node;
        
        return dummyHead.next;
    }
}