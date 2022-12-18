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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head, curr = head;
        int count = 1;
        while (count < k && curr != null && curr.next != null) {
            curr = curr.next;
            count++;
        }
        ListNode end = curr;
        if (count == k && end != null) { // If we reach the end node
            ListNode returnHead = reverseKGroup(end.next, k);
            ListNode reversedHead = reverse(start, k);
            start.next = returnHead;
            return reversedHead;
        }
        return head;
    }
     
    
    public ListNode reverse(ListNode start, int k) {
        int i = 0;
        ListNode curr = start, prev = null;
        while (i < k && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        return prev;
    }
}