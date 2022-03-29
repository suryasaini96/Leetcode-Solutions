/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = length(headA);
        int l2 = length(headB);
        int diff = Math.abs(l1-l2);
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        while(diff!=0){
            if (l1>l2)
                curr1 = curr1.next;
            if (l2>l1) 
                curr2 = curr2.next;
            diff--;
        }

        while (curr1!=null && curr2!=null) {
            if (curr1 == curr2)
                break;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr1;
    }
    
    static int length(ListNode head) {
        int length = 0;
        while (head!=null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}