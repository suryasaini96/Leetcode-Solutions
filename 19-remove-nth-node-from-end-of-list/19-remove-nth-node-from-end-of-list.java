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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        // Set second pointer at k places from first
        while(n!=0){
            second = second.next;
            n--;
        }
        if (second == null){ // In edge case n = length of list
            // Remove head
            head = head.next;
            return head;
        }

        // Loop till second pointer reaches the end
        // Move first and second pointer 1 step each time
        while(second.next!=null){
            second = second.next;
            first = first.next;
        }

        // Now first will be before the element to be removed
        // Removing the element
        first.next = first.next.next;
        return head;
    }
}