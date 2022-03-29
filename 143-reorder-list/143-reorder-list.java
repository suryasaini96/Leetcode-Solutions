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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        
        ListNode middle_node = getMiddleNode(head);
        ListNode reverse_middle = reverseList(middle_node);
        
        dummyNode = dummyNode.next;
        // Iterate lists till end and keep changing pointers in dummy node
        while (dummyNode!=null && reverse_middle!=null) {
            ListNode temp1 = dummyNode.next;
            dummyNode.next = reverse_middle;

            ListNode temp2 = reverse_middle.next;
            reverse_middle.next = temp1;
            
            reverse_middle = temp2;
            dummyNode = temp1;
        }
        
        return;
        
    }
    
    public ListNode getMiddleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}