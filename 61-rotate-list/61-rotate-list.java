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
    
    private static ListNode lastNode; 
    
    public ListNode rotateRight(ListNode head, int k) {
        // Base case 
        if (head == null || head.next == null || k == 0)
            return head;
        
        int n = listLength(head); // Find's list length and keeps track of lastNode
        // Rotate n-k times. If k > n then k = k % n;
        if (k>n)
            k = k % n;
        
        int pos = n - k;
        if (pos == 0 || pos == n) // Then we don't need to rotate the list
            return head;
        
        ListNode curr = head;
        // Go to n-k-1 position 
        pos = pos - 1;
        while (pos!=0) {
            curr = curr.next;
            pos--;
        }
        
        lastNode.next = head;
        head = curr.next;
        curr.next = null;
        
        return head;
    }
    
    private static int listLength(ListNode head) {
        ListNode curr = head;
        int length = 0;
        while (curr!=null) {
            lastNode = curr;
            curr = curr.next;
            length++;
        }
        return length;
    }
    
}